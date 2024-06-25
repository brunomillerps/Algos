package bmps.com.linkedlist;

import bmps.com.dsa.linkedlist.BrowserHistory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrowserHistoryTest {

    @Test
    public void test() {
//        ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
//        [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
//        Output:
//        [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

        var browser = new BrowserHistory("leetcode.com");
        browser.visit("google.com");
        browser.visit("facebook.com");
        browser.visit("youtube.com");// XXXX no anymore

        assertEquals("facebook.com", browser.back(1));
        assertEquals("google.com", browser.back(1));
        assertEquals("facebook.com", browser.forward(1));

        browser.visit("linkedin.com");

        assertEquals("linkedin.com", browser.forward(2));
        assertEquals("google.com", browser.back(2));
        assertEquals("leetcode.com", browser.back(7));
    }

}