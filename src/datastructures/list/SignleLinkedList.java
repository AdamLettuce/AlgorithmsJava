package datastructures.list;

public interface SignleLinkedList<T> {
    void addBegin(T data);

    T removeBegin();

    boolean isEmpty();

    int size();

    T get(int i);
}
