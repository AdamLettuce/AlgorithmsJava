package leetcode.queue;

class MyCircularQueue {

    int [] data;
    int front = -1;
    int rear = -1;

    public MyCircularQueue(int k) {
        data = new int[k];
    }

    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        if(front==-1) {
            front = 0;
        }
        data[(++rear)%data.length] = value;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        int result = data[front%data.length];
        ++front;
        if(front>rear) {
            front = -1;
            rear = -1;
        }
        return true;
    }

    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return data[front%data.length];
    }

    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        return data[rear%data.length];
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (rear+1)%data.length==front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */