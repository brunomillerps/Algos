package bmps.com.dsa.linkedlist;

public class ReverseAlternateLinkedList {

    /*
        Given a linked list of integers and a positive integer N. Create a new linked list by reversing every alternate N nodes of the linked list.
            If the number of nodes in the list or in the last group is less than N, just reverse the remaining nodes.
     */
    public ListNode<Integer> reverse(ListNode<Integer> head, int N) {
        if (head == null || N <= 0) {
            return head;
        }

        ListNode<Integer> current = head;
        ListNode<Integer> prev = null;
        boolean reverse = true;

        while (current != null) {
            ListNode<Integer> start = current;
            ListNode<Integer> end = current;
            int count = 1;

            // Move the end pointer to the end of the current N segment
            while (count < N && end.next != null) {
                end = end.next;
                count++;
            }

            ListNode<Integer> nextSegment = end.next;
            end.next = null;

            if (reverse) {
                // Reverse the current segment if needed
                ListNode<Integer> reversedSegment = reverseAlternate(start, N);

                // Connect the previous segment to the reversed segment
                if (prev != null) {
                    prev.next = reversedSegment;
                } else {
                    head = reversedSegment;
                }

                // Connect the end of the reversed segment to the next segment
                start.next = nextSegment;
                prev = start;
            } else {
                // If not reversing, just connect the previous part to the current part
                prev.next = start;
                prev = end;
            }

            // Move the current pointer to the next segment
            current = nextSegment;
            reverse = !reverse;
        }

        return head;

    }

    public ListNode<Integer> reverseAlternate(ListNode<Integer> head, int N) {
        ListNode<Integer> curNode = head;
        ListNode<Integer> prevNode = null;

        // 1 2, 3
        while(N > 0 && curNode != null) {
            var next = curNode.next;

            curNode.next = prevNode;
            prevNode = curNode;

            curNode = next;
            N--;
        }

        if (head != null) {
            head.next = curNode;
        }

        return prevNode;
    }
}
