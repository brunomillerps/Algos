package streams.src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Strategy {
    public static void main(String[] args) {

        var nums = List.of(1,2,3,4,5,6,7,8,9,10);

        // print even numbers
        System.out.println(totalValues(nums, it -> it % 2 == 0));
        // odd numbers
        System.out.println(totalValues(nums, it -> it % 2 != 0));
        //all nums
        System.out.println(totalValues(nums, it -> true));

        Map<Character, Integer> maps = new HashMap<>();
        
        maps.putIfAbsent('c',  1);
        maps.compute('c', (k, v) -> v + 1);

        System.out.println(maps.toString());
    }

    private static int totalValues(List<Integer> numbers, Predicate<Integer> selector) {
        return numbers.stream()
            .filter(selector)
            .mapToInt(i -> i)
            .sum();
    }
}
