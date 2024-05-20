package bmps.com.stacks;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 6;
        int diff = 0;
        List<String> combinations = new ArrayList<>();
        generate(n, diff, new StringBuilder(), combinations);
        System.out.println(combinations);

        System.out.println(IsGenerateParenthesesValid.isValidParentheses(String.join("", combinations)));
    }

    private static void generate(int n, int diff, StringBuilder curCombination, List<String> combinations) {
        if (diff < 0) return;

        if (n == 0) {
            if (diff == 0) {
                combinations.add(curCombination.toString());
            }
        } else {
            curCombination.append("(");
            generate(n-1, diff+1, curCombination, combinations);
            curCombination.deleteCharAt(curCombination.length() - 1 );

            curCombination.append(")");
            generate(n-1, diff-1, curCombination, combinations);
            curCombination.deleteCharAt(curCombination.length() - 1 );
        }
    }
}
