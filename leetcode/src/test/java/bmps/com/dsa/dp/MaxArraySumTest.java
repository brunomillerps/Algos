package bmps.com.dsa.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MaxArraySumTest {

    @ParameterizedTest
    @CsvSource({
            "'-2,1,3,-4,5', 8"
    })
    void maxSubsetSum(String numString, int expect) {
        MaxArraySum maxArraySum = new MaxArraySum();

        var listOfIntegers = Arrays.stream(numString.trim().split(","))
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());

        var res = maxArraySum.maxSubsetSumLoop(listOfIntegers);
        /*
        Subset      Sum
        [-2, 3, 5]   6
        [-2, 3]      1
        [-2, -4]    -6
        [-2, 5]      3
        [1, -4]     -3
        [1, 5]       6
        [3, 5]       8
         */

        Assertions.assertEquals(expect, res);


    }
}