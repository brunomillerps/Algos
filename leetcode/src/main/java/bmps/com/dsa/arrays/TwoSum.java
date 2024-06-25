package bmps.com.dsa.arrays;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int[] input = new int[]{2,7,11,15};
        int target = 26;

        System.out.println(Arrays.toString(twoSum(input, target)));
        System.out.println(Arrays.toString(twoSumUnsorted(input, target)));


        input = new int[]{2, 7, 11, 3, 6, 3, 6};

        System.out.println(allTwoSum(input, 9));
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

    public static int allTwoSum(int[] nums, int target) {
        int numOfSums = 0;
        var map = new  HashMap<Integer, Integer>();
        var seen = new HashSet<String>();

        for (int i = 0; i < nums.length; i++) {
            var key = String.valueOf(Math.abs(target - nums[i]));
            if (!seen.contains(key)) {
                if (map.containsKey(target - nums[i])) {
                    numOfSums++;
                    seen.add(key);
                }
                map.put(nums[i], i);
            }
        }

        return numOfSums;
    }

    public static int[] twoSum(int[] items, int target) {
        Arrays.sort(items);

        int l1 = 0;

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
