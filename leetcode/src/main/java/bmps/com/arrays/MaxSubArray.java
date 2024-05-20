package bmps.com.arrays;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSub = nums[0];
        int curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (curSum < 0) {
                curSum = 0;
            }

            curSum += nums[i];
            maxSub = Math.max(nums[i], curSum);

        }

        System.out.println(maxSub);
    }
}
