package bmps.com;

import java.util.ArrayList;
import java.util.List;

public class CyclicRangeGenerator {
    public static void main(String[] args) {
        List<Integer> result1 = generateCyclicRange(2, 5, 7);
        System.out.println(result1);  // Output: [2, 3, 4, 5]

        List<Integer> result2 = generateCyclicRange(5, 2, 7);
        System.out.println(result2);  // Output: [5, 6, 7, 1, 2]
    }

    public static List<Integer> generateCyclicRange(int start, int end, int boundary) {
        List<Integer> result = new ArrayList<>();

        if (start <= end) {
            for (int i = start; i <= end; i++) {
                result.add(i);
            }
        } else {
            for (int i = start; i <= boundary; i++) {
                result.add(i);
            }
            for (int i = 1; i <= end; i++) {
                result.add(i);
            }
        }

        return result;
    }
}
