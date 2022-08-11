package datastructures.queue;

import java.util.ArrayList;
import java.util.List;

public class QueueUsingArrayList implements MyQueue {

    private final List<Integer> items = new ArrayList<>();
    int capacity = 5;

    @Override
    public void enQueue(int value) {
        if(isFull()) {
            throw new IllegalArgumentException();
        }
        items.add(value);
    }

    @Override
    public int deQueue() {
        if(isEmpty()) {
            throw new IllegalArgumentException();
        }
        return items.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean isFull() {
        return items.size()==capacity;
    }

    @Override
    public int peek() {
        return items.get(0);
    }

    public static void main(String[] args) {
        MyQueue q = new QueueUsingArrayList();
        q.enQueue(1);
        q.enQueue(4);
        q.enQueue(7);

        System.out.println(q);

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}
