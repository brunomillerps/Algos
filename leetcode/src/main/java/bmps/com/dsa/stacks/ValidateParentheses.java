package bmps.com.dsa.stacks;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/*
You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.

The input string s is valid if and only if:

Every open bracket is closed by the same type of close bracket.
Open brackets are closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
Return true if s is a valid string, and false otherwise.

Example 1:
Input: s = "[]"
Output: true

Example 2:
Input: s = "([{}])"
Output: true

Example 3:
Input: s = "[(])"
Output: false
Explanation: The brackets are not closed in the correct order.

 */
public class ValidateParentheses {
    public boolean isValid(String s) {
        var map = new HashMap<String, String>();
        map.put("}", "{");
        map.put(")", "(");
        map.put("]", "[");

        Stack<String> stack = new Stack<>();

        for (var c : s.split("")) {
            if (!stack.isEmpty() && map.containsKey(c)) {
                if (!map.get(c).equals(stack.peek())) return false;
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
