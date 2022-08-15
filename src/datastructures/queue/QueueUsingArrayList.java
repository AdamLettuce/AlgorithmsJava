package datastructures.queue;

import java.util.ArrayList;
import java.util.List;

public class QueueUsingArrayList implements MyQueue {

    private final List<Integer> items = new ArrayList<>();
    int capacity = 5;

    @Override
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        items.add(value);
        return true;
    }

    @Override
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        items.remove(0);
        return true;
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
