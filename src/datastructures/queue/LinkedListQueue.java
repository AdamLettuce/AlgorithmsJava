package datastructures.queue;


import datastructures.queue.MyQueue;

public class LinkedListQueue implements MyQueue {

    private Node head;
    private Node tail;

    private static class Node {
        Node next;
        Node prev;
        Integer data;

        public Node(Integer data) {
            this.data = data;
        }
    }

    private final int size;
    private int count = 0;

    public LinkedListQueue(int size) {
        this.size = size;
    }

    @Override
    public void enQueue(int item) {
        Node newItem = new Node(item);
        if(isEmpty()) {
            head = tail = newItem;
        } else if(!isFull()) {
            newItem.prev = tail;
            tail.next = newItem;
            tail = newItem;
        }
        ++count;
    }

    @Override
    public int deQueue() {
        if(isEmpty()) {
            return -1;
        }
        Node oldHead = head;
        if(head!=tail) {
            head = head.next;
            oldHead.next = head.prev = null;
            return oldHead.data;
        }
        head.next = head.prev = null;
        tail = null;
        --count;
        return oldHead.data;
    }

    @Override
    public int peek() {
        if(isEmpty()) {
            return -1;
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean isFull() {
        return count == size;
    }
}
