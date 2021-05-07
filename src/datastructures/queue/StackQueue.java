package datastructures.queue;

import java.util.Stack;

public class StackQueue implements Queue {

    private Stack<Integer> first = new Stack<>();
    private Stack<Integer> second = new Stack<>();
    private int size;
    private int count = 0;

    public StackQueue(int size) {
        this.size = size;
    }

    @Override
    public void enqueue(Integer item) {
        if (first.size() < size) {
            first.push(item);
            ++count;
        }
    }

    @Override
    public Integer dequeue() {
        moveFromFirstToSecond();
        if (!second.isEmpty()) {
            --count;
            return second.pop();
        }
        return null;
    }

    @Override
    public Integer peek() {
        moveFromFirstToSecond();
        if (!second.isEmpty()) {
            return second.peek();
        }
        return null;
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
