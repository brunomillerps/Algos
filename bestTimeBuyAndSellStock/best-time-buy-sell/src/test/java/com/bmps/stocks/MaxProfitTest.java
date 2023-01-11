package com.bmps.stocks;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxProfitTest {

    @Test
    void should() {
        MaxProfit profit = new MaxProfit(List.of(1, 2, 3, 0, 3));

        var time = System.currentTimeMillis();
        Assertions.assertEquals(3, profit.execute());

        System.out.println(System.currentTimeMillis() - time);
    }
}
