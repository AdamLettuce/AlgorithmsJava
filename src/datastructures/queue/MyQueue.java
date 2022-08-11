package datastructures.queue;

public interface MyQueue {
    void enQueue(int value);
    int deQueue();
    boolean isEmpty();
    boolean isFull();
    int peek();
}
