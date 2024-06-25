package bmps.com.dsa.arrays;

public class PalindromeTwoPointers {

    public static void main(String[] args) {

        int[] nums = new int[] {1,2,7,7,2,1};

        System.out.println(isPalindrome(nums));
    }

    private static boolean isPalindrome(int[] nums) {
        int L = 0, R = nums.length - 1;

        while (L <= R) {

            if (nums[L] == nums[R]) {
                L += 1;
                R -= 1;
            } else {
                return false;
            }

        }

        return true;
    }
}
