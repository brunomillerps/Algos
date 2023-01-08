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
        List<List<Integer>> result = new ArrayList<>();

        // 2 7 10 15
        for (int i = 0; i < nums.length; i++) {
            
            var complementIndex = complements.get(nums[i]);
            if (complementIndex != null) {
                result.add(List.of(i, complementIndex));
            }

            var sb = new StringBuilder();
            sb.indexOf("A");

            complements.put(target - nums[i], i);
        }

        System.out.println(result.toString());
        return nums;
    }
} 