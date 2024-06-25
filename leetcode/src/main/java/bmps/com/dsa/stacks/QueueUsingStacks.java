package bmps.com.dsa.stacks;

import java.util.Stack;

public class QueueUsingStacks<T> {

    private final Stack<T> stackEnqueue;
    private final Stack<T> stackDequeue;

    public QueueUsingStacks() {
        this.stackDequeue = new Stack<>();
        this.stackEnqueue = new Stack<>();
    }

//    Enqueue operation: When an item is enqueued, it is pushed onto stackEnqueue.
    public void enqueue(T value) {
        stackEnqueue.push(value);
    }
//    Dequeue operation:
//        If stackDequeue is empty,
//          all elements from stackEnqueue are transferred to stackDequeue.
//        The top element of stackDequeue is then popped and returned.
    public T dequeue() {
        if (stackDequeue.empty()) {
            while(!stackEnqueue.empty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }

        if (stackDequeue.isEmpty()) return null;

        return stackDequeue.pop();
    }

    /*
        Peek operation:
        Similar to dequeue, but instead of popping the top
            element of stackDequeue, it is simply returned.
     */
    public T peek() {
        if (stackDequeue.empty()) {
            while(!stackEnqueue.empty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }

        if (stackDequeue.isEmpty()) return null;

        return stackDequeue.peek();
    }

}
