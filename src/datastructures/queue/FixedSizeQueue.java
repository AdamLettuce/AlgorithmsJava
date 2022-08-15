package datastructures.queue;

public class FixedSizeQueue implements MyQueue {

    public static final String THE_QUEUE_IS_FULL_CANNOT_EN_QUEUE = "The queue is full. Cannot enQueue: ";
    int front = -1;
    int rear = -1;

    int[] data;

    public FixedSizeQueue(int size) {
        data = new int[size];
    }

    @Override
    public boolean enQueue(int value) {
        if (isFull()) {
            System.out.println(THE_QUEUE_IS_FULL_CANNOT_EN_QUEUE + value);
            return false;
        } else {
            if (isEmpty()) {
                front = 0;
            }
            System.out.println("Enqueue: " + value);
            data[++rear] = value;
            return true;
        }
    }

    @Override
    public boolean deQueue() {
        if(isEmpty()) {
            System.out.println("The queue is empty. Cannot deQueue.");
            return false;
        }
        int result = data[front++];
        if(front>rear) {
            front = -1;
            rear = -1;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public boolean isFull() {
        return rear == data.length - 1;
    }

    @Override
    public int peek() {
        if(isEmpty()) {
            System.out.println("Cannot peek from the empty queue.");
            return -1;
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < data.length - 1; i++) {
            stringBuilder.append(data[i]).append(", ");
        }
        stringBuilder.append(data[data.length - 1]);
        return "Queue = [" + stringBuilder + "]";
    }

    public static void main(String[] args) {
        MyQueue q = new FixedSizeQueue(4);
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        System.out.println(q);

        System.out.println("Dequeue: " + (q.deQueue()));

        q.enQueue(7);

        System.out.println("Dequeue: " + (q.deQueue()));
        System.out.println("Dequeue: " + (q.deQueue()));

        System.out.println("Peek: " + (q.peek()));

        System.out.println("Dequeue: " + (q.deQueue()));

        System.out.println("Dequeue: " + (q.deQueue()));//non circular queue
//        System.out.println("Dequeue: " + (q.deQueue() == 7));//circular queue

        System.out.println("Peek: " +( q.peek()));
    }
}
