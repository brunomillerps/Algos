package bmps.com.stacks;

import jdk.jshell.execution.JdiInitiator;

import java.util.*;

public class IsGenerateParenthesesValid {
    public static void main(String[] args) {

        String parentheses = "((()))(())";
        System.out.println(isValidParentheses(parentheses));
        System.out.println(isValidParentheses_with_diff(parentheses));
    }

    public static boolean isValidParentheses(String parentheses) {

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < parentheses.length(); i++) {
            if (parentheses.charAt(i) == '(') {
                stack.push(parentheses.charAt(i));
            } else if (stack.isEmpty()) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private static boolean isValidParentheses_with_diff(String parentheses) {

        int diff = 0;

        for (int i = 0; i < parentheses.length(); i++) {
            if (parentheses.charAt(i) == '(') {
                diff += 1;
            } else if (diff == 0) {
                return false;
            } else {
                diff -= 1;
            }
        }
        return diff == 0;
    }

}
