package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {
    private static final Map<Integer, String> map = Map.of(
        2, "abc",
        3, "def",
        4, "ghi",
        5, "jkl",
        6, "mno",
        7, "qprs",
        8, "tuv",
        9, "wxyz");

    public static void main(String[] args) {

        List<String> result = new ArrayList<>();

        letterCombination(0, "", result, "23");

        System.out.println(result);
    }

    private static void letterCombination(int i, String curStr, List<String> result, String digits) {
        if (curStr.length() == digits.length()) {
            result.add(curStr);
            return;
        }

        var charIndex = Integer.valueOf(digits.split("")[i]);

        for (var charAt : map.get(charIndex).toCharArray()) {
            letterCombination(i + 1, curStr + charAt, result, digits);
        }
    }
}










