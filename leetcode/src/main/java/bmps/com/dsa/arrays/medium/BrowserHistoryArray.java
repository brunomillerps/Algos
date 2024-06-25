package bmps.com.dsa.arrays.medium;

import java.util.ArrayList;
import java.util.List;

/*
You have a browser of one tab where you start on the homepage and you can visit another url,
 get back in the history number of steps or move forward in the history number of steps.

Implement the BrowserHistory class:

BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
void visit(string url) Visits url from the current page. It clears up all the forward history.
string back(int steps) Move steps back in history.
        If you can only return x steps in the history and steps > x, you will return only x steps.
        Return the current url after moving back in history at most steps.

string forward(int steps) Move steps forward in history.
        If you can only forward x steps in the history and steps > x, you will forward only x steps.
        Return the current url after forwarding in history at most steps.

 */
public class BrowserHistoryArray {

    private int curIndex = 0;
    private final List<String> history = new ArrayList<>();

    public BrowserHistoryArray(String homepage) {
        this.history.add(homepage);
    }

    public void visit(String url) {
        this.curIndex++;
        this.history.subList(this.curIndex, this.history.size()).clear();
    }

    public String back(int steps) {
        this.curIndex = Math.max(this.curIndex - steps, 0);
        return history.get(curIndex);
    }

    public String forward(int steps) {
        this.curIndex = Math.min(this.curIndex + steps, history.size() - 1);
        return history.get(curIndex);
    }
}
