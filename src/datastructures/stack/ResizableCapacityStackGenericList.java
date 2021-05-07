package datastructures.stack;

import datastructures.list.MyList;

public class ResizableCapacityStackGenericList<T> {
    private int count = 0;
    MyList<T> elements = new MyList<>();

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
