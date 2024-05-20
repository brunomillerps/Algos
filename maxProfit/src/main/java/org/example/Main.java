package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static class BuyAndSellDay {
        private final int buyAt;
        private final int sellAt;

        BuyAndSellDay(int buyAt, int sellAt) {
            this.buyAt = buyAt;
            this.sellAt = sellAt;
        }

        @Override
        public String toString() {
            return "BuyAndSellDay{" +
                    "buyAt=" + buyAt +
                    ", sellAt=" + sellAt +
                    '}';
        }
    }
    public static void main(String[] args) {

        int price[] = {100, 180, 260, 310, 40, 535, 695};
        List<BuyAndSellDay> whenBuyAndSell = new ArrayList<>();

        var maxProfit = 0;

        for (int i = 1; i < price.length; i++) {
            if (price[i] > price[i - 1]) {
                maxProfit += price[i] - price[i - 1];
                whenBuyAndSell.add(new BuyAndSellDay(i-1, i));
            }
        }

        System.out.println(whenBuyAndSell);
        System.out.println(maxProfit);
    }
}