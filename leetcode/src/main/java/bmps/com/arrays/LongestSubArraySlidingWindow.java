package bmps.com.arrays;

import java.util.HashSet;
import java.util.Set;

/*
    the longest sub array, with the same value in each position
    Input: 4,2,2,9,9,9
    Output: 3
 */
public class LongestSubArraySlidingWindow {

    public static void main(String[] args) {
        int[] nums = new int[] {4,2,2,9,9,9};

        System.out.println(hasDuplicate(nums));
    }

    private static boolean hasDuplicate(int[] nums) {
        int longest = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[left] == nums[right]) longest += 1;

        }

        return false;
    }
}
