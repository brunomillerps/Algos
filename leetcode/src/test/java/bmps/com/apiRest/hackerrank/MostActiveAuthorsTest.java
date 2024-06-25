package bmps.com.apiRest.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


class MostActiveAuthorsTest {

    @Test
    void getMostAuthors() throws URISyntaxException, IOException, InterruptedException {

        MostActiveAuthors mostActiveAuthors = new MostActiveAuthors();

        var res = mostActiveAuthors.authors(1000);

        Assertions.assertArrayEquals(List.of("olalonde", "mpweiher", "coloneltcb").toArray(), res.toArray(new String[0]));
    }

}