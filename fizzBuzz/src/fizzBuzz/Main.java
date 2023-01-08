package fizzBuzz;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        IntStream.rangeClosed(1, 1000).forEach(Main::printFizzBuzz);
    }

    private static final Predicate<Integer> isDividedByThree = it -> it % 3 == 0;
    private static final Predicate<Integer> isDividedByFive = it -> it % 5 == 0;
    private static final Predicate<Integer> isDividedBySeven = it -> it % 7 == 0;

    private static void printFizzBuzz(Integer number) {

        var result = "";

        if (isDividedByThree.test(number)) {
            result += "Fizz";
        }

        if (isDividedByFive.test(number)) {
            result += "Buzz";
        }

        if (isDividedBySeven.test(number)) {
            result += "Bazz";
        }


        System.out.println(result.equals("") ? number : result);
    }

}