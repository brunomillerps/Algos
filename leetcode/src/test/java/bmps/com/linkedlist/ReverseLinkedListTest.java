package bmps.com.linkedlist;

import bmps.com.dsa.linkedlist.ListNode;
import bmps.com.dsa.linkedlist.ReverseLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    @Test
    void reverseList() {
//        Input: head = [0,1,2,3]
//        Output: [3,2,1,0]
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

        var head = new ListNode<Integer>(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        var res = reverseLinkedList.reverseList(head);

        assertEquals(3, res.val);
        assertEquals(2, res.next.val);
        assertEquals(1, res.next.next.val);
        assertEquals(0, res.next.next.next.val);
    }
}