package datastructures.stack;


class FixedCapacityStackGeneric<T> {
    private int N = 0;
    private T[] data;

    FixedCapacityStackGeneric(int n) {
        this.data = (T[]) new Object[n];
    }

    void push(T element) {
        data[N++] = element;
    }

    T pop() {
        return isEmpty() ? null : data[--N];
    }

    boolean isEmpty() {
        return N == 0;
    }

    int size() {
        return N;
    }
}