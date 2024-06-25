package bmps.com.dsa.linkedlist;

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
public class BrowserHistory {
    private ListNode<String> curNode;

    public BrowserHistory(String homepage) {
        this.curNode = new ListNode<>(homepage);
    }

    public void visit(String url) {

        var visitedUrl = new ListNode<>(url);
        visitedUrl.prev = this.curNode;
        this.curNode = visitedUrl;
    }

    public String back(int steps) {
        while(steps > 0 && this.curNode.prev != null) {
            var curTemp = this.curNode;
            this.curNode = this.curNode.prev;
            this.curNode.next = curTemp;
            steps -= 1;
        }
        return this.curNode.val;
    }

    public String forward(int steps) {
        while(steps > 0 && this.curNode.next != null) {
            var curTemp = this.curNode;
            this.curNode = this.curNode.next;
            this.curNode.prev = curTemp;
            steps -= 1;
        }
        return this.curNode.val;
    }
}
