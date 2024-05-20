package bmps.com.backtracking;

import jdk.jshell.spi.ExecutionControl;

import java.util.HashMap;
import java.util.Map;

public class MaxProfitBuySellCoolDown {

    // if you buy, the next day you only can sell or cooldown
    // if you sell, next day you only can is cooldown
    // prices = [1,2,3,0,2]
    // output = 3
    // explanation = [buy, sell, cooldown, buy, sell]
    public static void main(String[] args) {
        int[] prices = new int[] {1,2,3,0,2};

        int total = findMaxProfit(prices);
        System.out.println(total);
    }

    private static int findMaxProfit(int[] prices) {
        Map<String, Integer> cache = new HashMap<>();
        return findMaxProfitRecursive(0, true, prices, cache);
    }

    private static int findMaxProfitRecursive(int i, boolean buying, int[] prices, Map<String, Integer> cache) {
        if (i >= prices.length) return 0;

        String key = i + "" + buying;
        if (cache.containsKey(key)) return cache.get(key);

        if (buying) {
            var buy = findMaxProfitRecursive(i + 1, false, prices, cache) - prices[i];
            var cooldown = findMaxProfitRecursive(i+1, buying, prices, cache);
            cache.put(key, Math.max(buy, cooldown));
        } else {
            var sell = findMaxProfitRecursive(i + 2, true, prices, cache) + prices[i];
            var cooldown = findMaxProfitRecursive(i + 1, buying, prices, cache);
            cache.put(key, Math.max(sell, cooldown));
        }

        return cache.get(key);
    }


}
