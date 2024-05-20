package bmps.com.backtracking;

import java.util.*;
/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.


Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]


Example 2:
Input: nums = [0]
Output: [[],[0]]

 */


public class Subsets {

    private static List<List<Integer>> response = new ArrayList<>();
    private static int[] nums = new int[]{1,2,3};

    public static void main(String[] args) {

        findSubsets(0, new ArrayList<>());
        System.out.println(response);
    }

    private static void findSubsets(int i, List<Integer> subsets) {
        if (i >= nums.length) {
            response.add(new ArrayList<>(subsets));
            return;
        }

        subsets.add(nums[i]);
        findSubsets(i+1, subsets);

        subsets.remove(subsets.size() - 1);
        findSubsets(i+1, subsets);

    }

}
