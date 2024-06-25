package bmps.com.dsa.arrays;

 /*
    find the first and the last index of a given array of numbers

    Solution 1:

    Iterate through the array until finding the first element, and continue until finding the last.
    it takes O(N)

    Solution 2:
    Run binary search in the array to find the first element, and then run the binary search again to find the last
    index.
  */

import java.util.Arrays;

public class FirstAndLastIndexSortedArray {
    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,5,5,5,5,5,5,5,7,8,9};
        int target = 5;
        int[] result = findFirstAndLastIndex(nums, target);
        System.out.println(Arrays.toString(result));

        nums = new int[]{5,5,5,5,5};
        result = findFirstAndLastIndex(nums, target);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findFirstAndLastIndex(int[] nums, int target) {
        int first = findFirstIndex(nums, target);
        int last = findLastIndex(nums, target);

        return new int[]{first, last};
    }
    /*
           0  1  2  3  4  5  6  7  8  9 10 11 12
          {1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 7, 8, 9}
          L                  M                  R
     */

    private static int findFirstIndex(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l <= r) {
            int mid = (l+r)/2;
            if (nums[mid] == target && (mid-1 < 0 || nums[mid-1] < target)) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    /*
       0  1  2  3  4  5  6  7  8  9 10 11 12
      {1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 7, 8, 9}
       L                 M                 R
    */
    private static int findLastIndex(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l <= r) {
            int mid = (l+r)/2;
            if (nums[mid] == target && (mid+1 > nums.length-1 || nums[mid+1] > target)) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
}
