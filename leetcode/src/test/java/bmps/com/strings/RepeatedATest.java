package bmps.com.strings;

import bmps.com.dsa.strings.RepeatedA;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedATest {

    @ParameterizedTest
    @CsvSource({
            "'a', 1000000000000, 1000000000000",
            "'ab', 1000000000000, 500000000000",
            "'abc', 1000000000000, 333333333334",
    })
    void repeatedString(String a, long n, long expected) {
        RepeatedA repeatedA = new RepeatedA();

        var res = repeatedA.repeatedString(a, n);
        assertEquals(expected, res);
    }
}