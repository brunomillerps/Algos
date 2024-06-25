package bmps.com.dsa.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.


Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 */
public class CombinationsSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,6,7};

        int target = 7;
        List<Integer> curSolution = new ArrayList<>();
        List<List<Integer>> solution = new ArrayList<>();

        combinations(0, nums, target, 0, curSolution, solution);

        System.out.println(solution);


        nums = new int[]{2,3,5};
        target = 8;
        curSolution = new ArrayList<>();
        solution = new ArrayList<>();

        combinations(0, nums, target, 0, curSolution, solution);
        System.out.println(solution);

    }

    // 2, 3, 6, 7
    private static void combinations(int i, int[] nums, int target, int total, List<Integer> curSolution, List<List<Integer>> solution) {
        if (i >= nums.length || total > target) return;

        if (total == target) {
            solution.add(new ArrayList<>(curSolution));
            return;
        }

        curSolution.add(nums[i]);
        combinations(i, nums, target, total + nums[i], curSolution, solution);
        curSolution.remove(curSolution.size()-1);
        combinations(i+1, nums, target, total, curSolution, solution);

    }
}
