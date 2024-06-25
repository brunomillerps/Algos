package bmps.com.dsa.arrays;

import java.util.Arrays;

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
