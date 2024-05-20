package bmps.com.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

    public static void main(String[] args) {
        System.out.println("Hello world!");

    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> isDuplicated = new HashSet<>();

        for (int num : nums) {
            if (isDuplicated.contains(num)) {
                return true;
            }

            isDuplicated.add(num);
        }

        return false;
    }
}
