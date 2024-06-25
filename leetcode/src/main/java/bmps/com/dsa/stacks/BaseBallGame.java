package bmps.com.dsa.stacks;

import java.util.Stack;

/*
ou are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.

You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:

An integer x.
Record a new score of x.
'+'.
Record a new score that is the sum of the previous two scores.
'D'.
Record a new score that is the double of the previous score.
'C'.
Invalidate the previous score, removing it from the record.
Return the sum of all the scores on the record after applying all the operations.

The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.



Example 1:

Input: ops = ["5","2","C","D","+"]
Output: 30
Explanation:
"5" - Add 5 to the record, record is now [5].
"2" - Add 2 to the record, record is now [5, 2].
"C" - Invalidate and remove the previous score, record is now [5].
"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
The total sum is 5 + 10 + 15 = 30.
Example 2:

Input: ops = ["5","-2","4","C","D","9","+","+"]
Output: 27
Explanation:
"5" - Add 5 to the record, record is now [5].
"-2" - Add -2 to the record, record is now [5, -2].
"4" - Add 4 to the record, record is now [5, -2, 4].
"C" - Invalidate and remove the previous score, record is now [5, -2].
"D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
"9" - Add 9 to the record, record is now [5, -2, -4, 9].
"+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
"+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
Example 3:

Input: ops = ["1","C"]
Output: 0
Explanation:
"1" - Add 1 to the record, record is now [1].
"C" - Invalidate and remove the previous score, record is now [].
Since the record is empty, the total sum is 0.
 */
public class BaseBallGame {

    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if ("+".equals(op)) {
                stack.push(stack.get(stack.size() - 1) + stack.get(stack.size() - 2));
            } else if ("D".equals(op)) {
                stack.push(stack.peek() * 2);
            } else if ("C".equals(op)) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        return stack.stream().reduce(Integer::sum).orElse(0);
    }

    public int calPointsArray(String[] operations) {
        int[] scores = new int[operations.length];
        int i = -1;
        for (String op : operations) {
            i++;
            if ("+".equals(op)) {
                scores[i] = scores[i - 1] + scores[i - 2];
            } else if ("D".equals(op)) {
                scores[i] = 2 * scores[i - 1];
            } else if ("C".equals(op)) {
                i -= 2;
            } else {
                scores[i] = Integer.parseInt(op);
            }
        }

        int ans = 0;

        while(i >= 0) {
            ans += scores[i];
            i--;
        }

        return ans;
    }
}
