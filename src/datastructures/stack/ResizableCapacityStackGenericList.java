package datastructures.stack;

import datastructures.list.SingleLinkedList;

public class ResizableCapacityStackGenericList<T> {
    private int count = 0;
    SingleLinkedList<T> elements = new SingleLinkedList<>();

    void push(T element) {
        elements.addBegin(element);
        ++count;
    }

    T pop() {
        --count;
        return elements.removeBegin();
    }

    int size() {
        return count;
    }

    boolean isEmpty() {
        return count == 0;
    }



}
