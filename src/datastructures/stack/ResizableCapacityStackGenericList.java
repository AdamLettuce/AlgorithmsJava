package datastructures.stack;

import datastructures.list.SingleLinkedListComplex;

public class ResizableCapacityStackGenericList<T> {
    private int count = 0;
    SingleLinkedListComplex<T> elements = new SingleLinkedListComplex<>();

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
