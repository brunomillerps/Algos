package bmps.com.dsa.linkedlist;

import java.util.Objects;

public class ListNode<T> {
    public T val;
    public ListNode<T> next;
    public ListNode<T> prev;
    public ListNode() {}
    public ListNode(T val) { this.val = val; }
    public ListNode(T val, ListNode<T> next) { this.val = val; this.next = next; }
    public ListNode(T val, ListNode<T> prev, ListNode<T> next) { this.val = val; this.prev = prev; this.next = next; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode<?> listNode = (ListNode<?>) o;
        return Objects.equals(val, listNode.val);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(val);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
