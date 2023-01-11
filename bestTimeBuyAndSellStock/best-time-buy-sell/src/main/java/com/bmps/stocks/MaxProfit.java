package com.bmps.stocks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MaxProfit {
    private List<Integer> prices;
    private final Map<String, Integer> cache = new HashMap<>();

    int execute() {
        // State: Buying or Selling
        // If buying -> i + 1
        // If selling -> i + 2 (skip one day of cool down)

        boolean buying = true;
        // DFS
        return bestPrice(prices.get(0), buying);
    }

    private int bestPrice(int dayIndex, boolean buying) {
        if (dayIndex >= prices.size()) {
            return 0;
        }
        var cacheKey = "%s#%s".formatted(dayIndex, buying);

        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }

        var coolDown = bestPrice(dayIndex + 1, buying);
        var profit = 0;

        if (buying) {
            profit = bestPrice(dayIndex + 1, !buying) - prices.get(dayIndex);
        } else {
            profit = bestPrice(dayIndex + 2, !buying) + prices.get(dayIndex);
        }

        cache.put(cacheKey, Math.max(profit, coolDown));
        return cache.get(cacheKey);
    }
}
