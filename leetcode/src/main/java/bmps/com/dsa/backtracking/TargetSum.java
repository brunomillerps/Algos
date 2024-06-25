package bmps.com.dsa.backtracking;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,1,1};
        int target = 3;

        int result = findTargetSumWays(nums, target);
        System.out.println(result);
    }

    private static int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> cache = new HashMap<>();
        return findTargetSumWaysRecursive(0, 0, nums, target, cache);
    }

    private static int findTargetSumWaysRecursive(int i, int total, int[] nums, int target, Map<String, Integer> cache) {
        if (i == nums.length)
            return (total == target) ? 1 : 0;
        if (cache.containsKey(i + "," + total)) {
            return cache.get(i + "," + total);
        }

        int val = findTargetSumWaysRecursive(i + 1, total + nums[i], nums, target, cache) +
                  findTargetSumWaysRecursive(i + 1, total - nums[i], nums, target, cache);

        cache.put(i + "," + total, val);
        return val;
    }
}
