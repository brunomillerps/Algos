package bmps.com.linkedlist;

import bmps.com.dsa.linkedlist.ListNode;
import bmps.com.dsa.linkedlist.MergeLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeLinkedListTest {

    @Test
    void mergeTwoLists() {

        var l1 = new ListNode<>(1);
        var l2 = new ListNode<>(4);

        l1.next = new ListNode<>(2);
        l1.next.next = new ListNode<>(3);

        var res = new MergeLinkedList().mergeTwoLists(l2, l1);

        assertEquals(1, res.val);
        assertEquals(2, res.next.val);
        assertEquals(3, res.next.next.val);
        assertEquals(4, res.next.next.next.val);
    }
}