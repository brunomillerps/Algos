package bmps.com.arrays;

import bmps.com.dsa.arrays.easy.RemoveDuplicatesSortedArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesSortedArrayTest {

    @Test
    void test1() {
//        Input: nums = [1,1,2]
//        Output: 2, nums = [1,2,_]
        var nums = new int[]{1,1,2};
        var expected = new int[]{1,2,};

        var removeDuplicates = new RemoveDuplicatesSortedArray();

        var res = removeDuplicates.removeDuplicates(nums);

        Assertions.assertEquals(2, res);
        for (int i = 0; i < res; i++) {
            assertEquals(expected[i], nums[i]);
        }
    }
}