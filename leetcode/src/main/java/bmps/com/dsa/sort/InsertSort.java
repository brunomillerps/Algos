package bmps.com.dsa.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[] {8, 3, 9, 0, 1};
        // 0, 1, 3, 8, 9

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            var j = i - 1;
            while (j >= 0 && arr[j + 1] < arr[j]) {
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j -= 1;
            }
        }
    }
}
