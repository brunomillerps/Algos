package bmps.com.dsa.arrays.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    @Test
    void lcp() {

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        var res = longestCommonPrefix.lcp(List.of("flower", "flow", "flight"));
        Assertions.assertEquals("fl", res);
    }
}