package bmps.com.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

    Example 1:

    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    Example 2:

    Input: digits = ""
    Output: []
    Example 3:

    Input: digits = "2"
    Output: ["a","b","c"]
*/

public class LetterCombinationsPhoneNumber {
    static Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(2, "ABC");
        map.put(3, "DEF");

        List<String> res = new ArrayList<>();
        allCombinations(0, "", res, "23");

        System.out.println(res);
    }

    private static void allCombinations(int i, String curString, List<String> res, String digits) {
        if (curString.length() == digits.length()) {
            res.add(curString);
            return;
        }

        String letters = map.get(Integer.valueOf(String.valueOf(digits.charAt(i))));
        for (String c : letters.split("")) {
            allCombinations(i+1, curString + c, res, digits);
        }
    }
}
