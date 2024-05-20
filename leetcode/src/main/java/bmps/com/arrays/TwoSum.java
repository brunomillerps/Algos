package bmps.com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] input = new int[]{2,7,11,15};
        int target = 26;

        System.out.println(Arrays.toString(twoSum(input, target)));
        System.out.println(Arrays.toString(twoSumUnsorted(input, target)));
    }

    /*
        input: [2,7,11,15], target = 9
        output: [0, 1]
     */
    public static int[] twoSumUnsorted(int[] nums, int target) {

        // key -> value
        // value -> index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[] {map.get(target-nums[i]), i };
            }
            map.put(nums[i], i);
        }

        return new int[]{-1,-1};
    }

    public static int[] twoSum(int[] items, int target) {
        Arrays.sort(items);

        int l = 0, r = items.length - 1;

        while (l < r) {
            if (items[l]+items[r] > target) {
                r -= 1;
            } else if (items[l]+items[r] < target) {
                l += 1;
            } else {
                return new int[] {l, r};
            }
        }

        return new int[]{-1,-1};
    }
}
