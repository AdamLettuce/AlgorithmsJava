package datastructures.list.doublelinked;

public interface DoubleLinkedList<T> {
    void addBegin(T data);
    void addEnd(T data);

    T removeBegin();
    T removeEnd();

    boolean isEmpty();

    int size();

    T get(int i);
}
