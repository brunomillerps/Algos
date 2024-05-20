package twoSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    
    public static void main(String[] args) {
        /*
         2  7  10  15
         0  1  2   3

         [0][3] = true
         [1][2] = true
         */
        int[] nums = {2, 7, 10, 15};
        twoSum(nums, 17);

    }

    private static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> complements = new HashMap<>();

        // 2 7 10 15
        for (int i = 0; i < nums.length; i++) {
            var elIndx = complements.get(target-nums[i]);
            if ( elIndx != null) {
                return new int[] {elIndx, };
            }

            complements.put(nums[i], i);
        }

        return nums;
    }
} 