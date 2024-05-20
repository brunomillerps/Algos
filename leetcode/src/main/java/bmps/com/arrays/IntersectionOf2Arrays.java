package bmps.com.arrays;

import javax.swing.*;
import java.util.*;

/*
Given two integer arrays nums1 and nums2, return an array of their
intersection
. Each element in the result must be unique and you may return the result in any order.



Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

 */
public class IntersectionOf2Arrays {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] nums1 = new int[]{1,2,2,1}, nums2 = new int[]{2,2};

        var intersec = intersectionArray(nums1, nums2);

        System.out.println(intersec);
        // [2]

        nums1 = new int[]{4,9,5};
        nums2 = new int[]{9,4,9,8,4};
        intersec = intersectionArray(nums1, nums2);

        System.out.println(intersec);
    }

    private static List<Integer> intersectionArray(int[] nums1, int[] nums2) {
        Set<Integer> els = new HashSet<>();
        for (int i : nums1) {
            els.add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int i : nums2) {
            if (els.remove(i)) {
                result.add(i);
            }
        }

        return result;
    }
}
