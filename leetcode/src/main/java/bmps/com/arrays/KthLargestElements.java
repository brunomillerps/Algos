package bmps.com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class KthLargestElements {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] els = {10000, 87, 3, 1, 2};
        int K = 2;

        System.out.println(Arrays.toString(kth(els, K)));
    }

    private static int[] kth(int[] els, int k) {
        Arrays.sort(els);
        int[] res = new int[k];

        for (int i = 0; i < res.length; i++) {
            res[i] = els[els.length-1-i];
        }

        return res;
    }
}
