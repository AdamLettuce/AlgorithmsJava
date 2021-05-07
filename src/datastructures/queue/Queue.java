package datastructures.queue;

public interface Queue {

    void enqueue(Integer item);

    Integer dequeue();

    Integer peek();

    boolean isEmpty();

    boolean isFull();

}
