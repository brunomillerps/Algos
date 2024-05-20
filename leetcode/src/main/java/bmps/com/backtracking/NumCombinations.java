package bmps.com.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.


Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.

 */
public class NumCombinations {
    public static void main(String[] args) {
        int n = 4, k = 3;
//        Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]

        System.out.println(combinations(n, k));

    }

    private static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> solution = new ArrayList<>();
        combinationsRecursive(1, n, k, new ArrayList<>(), solution);
        return solution;
    }

    private static void combinationsRecursive(int i, int n, int k, List<Integer> curSolution, List<List<Integer>> solution) {
        if ( curSolution.size() == k) {
            solution.add(new ArrayList<>(curSolution));
            return;
        }

        if (i > n) {
            return;
        }

        for (int j = i; j < n + 1; j++) {
            curSolution.add(j);
            combinationsRecursive(j + 1, n, k, curSolution, solution);
            curSolution.remove(curSolution.size() - 1);
        }
    }
}
