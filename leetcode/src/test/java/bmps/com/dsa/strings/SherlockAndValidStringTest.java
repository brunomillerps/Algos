package bmps.com.dsa.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SherlockAndValidStringTest {

    @ParameterizedTest
    @CsvSource({
            "'abcdefghhgfedecba', 'YES'",
            "'aabbcd', 'NO'",
            "'aabbccddeefghi', 'NO'",
            "'aabbc', 'YES'"
    })
    void isValid(String a, String isValid) {
        var  validString = new SherlockAndValidString();
        Assertions.assertEquals(isValid, validString.isValid(a));
    }
}