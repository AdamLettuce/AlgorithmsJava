package datastructures.list.signlelinked;

public interface SignleLinkedList<T> {
    void addBegin(T data);

    void addAt(int position, int value);

    T removeBegin();

    boolean isEmpty();

    int size();

    T get(int i);
}
