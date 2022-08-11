package datastructures.queue;

import datastructures.queue.MyQueue;

import java.util.Stack;

public class StackQueue implements MyQueue {

    private final Stack<Integer> first = new Stack<>();
    private final Stack<Integer> second = new Stack<>();
    private final int size;
    private int count = 0;

    public StackQueue(int size) {
        this.size = size;
    }

    @Override
    public void enQueue(int item) {
        if (first.size() < size) {
            first.push(item);
            ++count;
        }
    }

    @Override
    public int deQueue() {
        moveFromFirstToSecond();
        if (!second.isEmpty()) {
            --count;
            return second.pop();
        }
        return -1;
    }

    @Override
    public int peek() {
        moveFromFirstToSecond();
        if (!second.isEmpty()) {
            return second.peek();
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean isFull() {
        return count == size;
    }

    private void moveFromFirstToSecond() {
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }
    }
}
