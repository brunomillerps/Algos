package bmps.com.deliveroo.weather;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeatherSearch {

    public static void main(String[] args) {
        System.out.println(weatherStation("Dallas"));
    }

    public static List<String> weatherStation(String keyword) {
        if (keyword == null || keyword.isBlank()) return List.of();

        Gson gson = new Gson();

        HttpClient client = HttpClient.newHttpClient();
        String response = null;
        List<WeatherResponse> weatherResponses;
        try {
            String weatherURI = "https://jsonmock.hackerrank.com/api/weather/search?name=" + keyword;
            response = client
                    .send(HttpRequest.newBuilder(new URI(weatherURI))
                                    .GET()
                                    .build(),
                            HttpResponse.BodyHandlers.ofString())
                    .body();

            weatherResponses = new ArrayList<>();
            WeatherResponse wr = gson.fromJson(response, WeatherResponse.class);
            weatherResponses.add(wr);

            if (wr.total_pages() > 1) {
                List<URI> uris = new ArrayList<>();
                weatherURI += "&page=";

                for (int i = 2; i <= wr.total_pages(); i++) {
                    uris.add(new URI(weatherURI + i));
                }

                ExecutorService ex = Executors.newFixedThreadPool(4);

                HttpClient client2 = HttpClient.newBuilder().executor(ex).build();
                var futures = uris.stream()
                        .map(target -> client2
                                .sendAsync(
                                        HttpRequest.newBuilder(target)
                                                .GET()
                                                .build(),
                                        HttpResponse.BodyHandlers.ofString())
                                .thenApply(HttpResponse::body))
                        .toList();

                var result = futures.stream().map(CompletableFuture::join)
                        .map(curResponse -> gson.fromJson(curResponse, WeatherResponse.class))
                        .toList();

                weatherResponses.addAll(result);
            }

            // Exceptions to be handled latter better
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }


        var resultWeathers = weatherResponses.stream()
                .flatMap(weatherPage -> weatherPage.data().stream())
                .map(w -> w.name() + "," + w.weather().replace(" degree", "") + "," + w.status().get(0).replace("Wind: ", "") + "," + w.status().get(1).replace("Humidity: ", ""))
                .toList();

        return resultWeathers;
    }

    record Weather (String name, String weather, List<String> status) {
    }

    record WeatherResponse(
            int page, int per_page, int total,
            int total_pages, List<Weather> data) {
    }

}
