package datastructures.queue;

public class ArrayQueue implements Queue {

    private Integer[] data;
    private int tail = 0;
    private int head = 0;

    public ArrayQueue(Integer size) {
        this.data = new Integer[size];
    }

    @Override
    public void enqueue(Integer item) {
        if (!isFull()) {
            data[(tail++) % data.length] = item;
        }
    }

    @Override
    public Integer dequeue() {
        int dequeuedIndex = (head++) % data.length;
        Integer result = data[dequeuedIndex];
        data[dequeuedIndex] = null;
        return result;
    }

    @Override
    public Integer peek() {
        return data[head % data.length];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == data.length;
    }

}