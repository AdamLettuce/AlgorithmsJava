package datastructures.queue;

public interface MyQueue {
    boolean enQueue(int value);
    boolean deQueue();
    boolean isEmpty();
    boolean isFull();
    int peek();
}
