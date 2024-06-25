package bmps.com.dsa.linkedlist.hard;

import bmps.com.dsa.linkedlist.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {

    public ListNode<Integer> merge(List<ListNode<Integer>> nodes) {
        PriorityQueue<ListNode<Integer>> queue = new PriorityQueue<>(Comparator.comparing(integerListNode -> integerListNode.val));
        queue.addAll(nodes);

        ListNode<Integer> dummy = new ListNode<>(0);
        ListNode<Integer> tail = dummy;

        while (!queue.isEmpty()) {
            var smallNode = queue.poll();

            tail.next = smallNode;
            tail = tail.next;

            if (smallNode.next != null) {
                queue.add(smallNode.next);
            }
        }

        return dummy.next;
    }

}
