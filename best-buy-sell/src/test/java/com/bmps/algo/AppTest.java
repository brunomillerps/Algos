package com.bmps.algo;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {

        var prices = List.of(7, 1, 5, 3, 6, 4);
        var myProfit = new MaxProfit();

        var result = myProfit.getMaxProfit(prices);
        assertEquals(5, result);
    }
}
