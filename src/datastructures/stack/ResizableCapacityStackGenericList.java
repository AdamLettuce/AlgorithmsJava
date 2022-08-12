package datastructures.stack;

import datastructures.list.signlelinked.SingleLinkedListTwoPointersAdvancedMethods;

public class ResizableCapacityStackGenericList<T> {
    private int count = 0;
    SingleLinkedListTwoPointersAdvancedMethods<T> elements = new SingleLinkedListTwoPointersAdvancedMethods<>();

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
