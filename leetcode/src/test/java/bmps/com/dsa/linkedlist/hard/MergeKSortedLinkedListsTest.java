package bmps.com.dsa.linkedlist.hard;

import bmps.com.dsa.linkedlist.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeKSortedLinkedListsTest {

    @Test
    void merge() {
        var root1 = new ListNode<>(1);
        root1.next = new ListNode<>(4);
        root1.next.next = new ListNode<>(5);

        var root2 = new ListNode<>(1);
        root1.next = new ListNode<>(3);
        root1.next.next = new ListNode<>(4);


        var root3 = new ListNode<>(2);
        root1.next = new ListNode<>(6);


        MergeKSortedLinkedLists merge = new MergeKSortedLinkedLists();

        merge.merge(List.of(root1, root2, root3));
    }
}