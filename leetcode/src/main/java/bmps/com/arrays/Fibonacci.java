package bmps.com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    //0 1 1 2 3 5

    public static void main(String[] args) {

        long a = System.currentTimeMillis();
        Long[] ans = new Long[13];
        ans[0] = 0L;
        ans[1] = 1L;

        // O(n)
        for (int i = 2; i < ans.length; i++) {
            ans[i] = ans[i-1] + ans[i-2];
        }

        System.out.println("time = " + (System.currentTimeMillis() - a) + " ans = " + Arrays.toString(ans));

        a = System.currentTimeMillis();
        Map<Integer, Long> visited = new HashMap<>();
        long res = fib(13, visited);
        System.out.println("time = " + (System.currentTimeMillis() - a) + " ans = " + res);
    }

    public static long fib(int n, Map<Integer, Long> visited) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (visited.containsKey(n)) return visited.get(n);

        long result = fib(n - 1, visited) + fib(n - 2, visited);
        visited.put(n, result);
        System.out.println("n = " + n + " result = " + result);
        return result;
    }
}
