package bmps.com.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
    Given a string s, partition s such that every
    substring of the partition is a palindrome . Return all possible palindrome partitioning of s.

    Example 1:
    Input: s = "aab"
    Output: [["a","a","b"],["aa","b"]]

    Example 2:
    Input: s = "a"
    Output: [["a"]]
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();

        partitions(0, "aab", part, res);

        System.out.println(res);
    }

    private static void partitions(int i, String str, List<String> part, List<List<String>> res) {
        if (i >= str.length()) {
            res.add(new ArrayList<>(part));
            return;
        }

        for (int j = i; j < str.length(); j++) {
            if (isPalindrome(str, i, j)) {
                part.add(str.substring(i, j + 1));
                partitions(j + 1, str, part, res);
                part.remove(part.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String str, int l, int r) {
        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l += 1;
            r -= 1;
        }
        return true;
    }
}
