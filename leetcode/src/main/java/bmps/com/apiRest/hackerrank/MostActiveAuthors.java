package bmps.com.apiRest.hackerrank;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.image.DataBufferUShort;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class MostActiveAuthors {

    public List<String> authors(int threshold) throws URISyntaxException, IOException, InterruptedException {
        var jackson = new ObjectMapper();


        HttpClient client = HttpClient.newHttpClient();
        String response = client
                .send(HttpRequest.newBuilder(new URI("https://jsonmock.hackerrank.com/api/article_users" ))
                                .GET()
                                .build(),
                        HttpResponse.BodyHandlers.ofString())
                .body();

        List<AuthorsResponse> authorsResponses = new ArrayList<>();
        var authorResponse = jackson.readValue(response, new TypeReference<AuthorsResponse>(){});

        authorsResponses.add(authorResponse);

        if (authorResponse.getTotal_pages() > 1) {
            List<URI> authorsUris = new ArrayList<>();

            for (int i = 2; i <= authorResponse.getTotal_pages(); i++) {
                authorsUris.add(new URI("https://jsonmock.hackerrank.com/api/article_users?page=" + i));
            }

            ExecutorService ex = Executors.newFixedThreadPool(4);

            HttpClient client2 = HttpClient.newBuilder().executor(ex).build();
            var futures = authorsUris.stream()
                    .map(target -> client2
                            .sendAsync(
                                    HttpRequest.newBuilder(target)
                                            .GET()
                                            .build(),
                                    HttpResponse.BodyHandlers.ofString())
                            .thenApply(HttpResponse::body))
                    .collect(Collectors.toList());

            var result = futures.stream().map(CompletableFuture::join)
                    .map(curResponse -> {
                        try {
                            return jackson.readValue(curResponse, new TypeReference<AuthorsResponse>(){});
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.toUnmodifiableList());

            authorsResponses.addAll(result);
        }


        var userNames = authorsResponses.stream()
                .flatMap(authorPage -> authorPage.getData().stream())
                .filter(author -> author.getSubmission_count() > threshold)
                .map(Authors::getUsername)
                .collect(Collectors.toList());

        return userNames;
    }
}


