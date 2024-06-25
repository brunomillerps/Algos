package bmps.com.arrays.medium;

import bmps.com.dsa.arrays.medium.SherlockAndAnagrams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SherlockAndAnagramsTest {

    @ParameterizedTest
    @CsvSource({
            "'abba', 4",
            "'abcd', 0"
    })
    void sherlockAndAnagrams(String a, int anagrams) {
        var sherlockAndAnagrams = new SherlockAndAnagrams();

        var res = sherlockAndAnagrams.sherlockAndAnagrams(a);

        Assertions.assertEquals(anagrams, res);
    }
}