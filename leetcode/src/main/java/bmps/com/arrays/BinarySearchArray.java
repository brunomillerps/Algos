package bmps.com.arrays;

import java.util.List;

public class BinarySearchArray {

    public static void main(String[] args) {

        System.out.println(exists(5, List.of(1,2,3,4,5,6,7,8,9)));
    }

    public static boolean exists(int target, List<Integer> arr) {

        int low = 0, mid = 0;
        int high = arr.size() - 1;
        while (low <= high) {
            mid = (low + high) / 2;

            if (target > arr.get(mid)) {
                low = mid + 1;
            } else if (target < arr.get(mid)) {
                high = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}

