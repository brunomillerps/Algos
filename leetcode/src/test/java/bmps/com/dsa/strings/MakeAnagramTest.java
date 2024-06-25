package bmps.com.dsa.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MakeAnagramTest {

    @ParameterizedTest
    @CsvSource({
            "'fcrxzwscanmligyxyvym', 'jxwtrhvujlmrpdoqbisbwhmgpmeoke', 30",
            "'cde', 'abc', 4",
            "'showman', 'woman', 2"
    })
    void makeAnagram(String a, String b, int deletedChars) {
        MakeAnagram makeAnagram = new MakeAnagram();
        var chars = makeAnagram.makeAnagram(a, b);
        Assertions.assertEquals(deletedChars, chars);
    }
}