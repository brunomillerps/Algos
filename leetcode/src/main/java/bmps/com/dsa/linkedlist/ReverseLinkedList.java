package bmps.com.dsa.linkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode curNode = head;
        ListNode prevNode = null;

        while(curNode != null) {
            var nextTemp = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextTemp;
        }

        return prevNode;
    }
}


