package bmps.com.dsa.arrays;

import java.util.HashSet;
import java.util.Set;

public class DuplicateSlidingWindow {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,5,-3,9};
        int windowOf = 3;

        System.out.println(hasDuplicate(nums, windowOf));
    }

    private static boolean hasDuplicate(int[] nums, int windowOf) {

        Set<Integer> window = new HashSet<>();
        int L = 0;

        for (int R = 0; R < nums.length; R++) {
            if (R - L + 1 > windowOf) {
                window.remove(nums[L]);
                L += 1;
            }

            if (window.contains(nums[R])) return true;
            window.add(nums[R]);
        }

        return false;
    }
}
