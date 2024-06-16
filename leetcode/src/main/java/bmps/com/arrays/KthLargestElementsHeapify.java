package bmps.com.arrays;

import java.util.*;

public class KthLargestElementsHeapify {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] els = {10000, 87, 3, 1, 2};
        int K = 2;

        System.out.println(Arrays.toString(kth(els, K)));
    }

    private static int[] kth(int[] els, int k) {

        Queue<Integer> queue = new PriorityQueue<>(Comparator.<Integer>naturalOrder().reversed());
        int[] res = new int[k];

        for (int el : els) {
            queue.add(el);
        }

        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            res[i] = queue.poll();
        }

        return res;
    }
}
