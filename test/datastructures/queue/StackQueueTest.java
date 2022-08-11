package datastructures.queue;

public class StackQueueTest extends ArrayQueueTest {

    @Override
    protected MyQueue getInstanceSizeOne() {
        return new StackQueue(1);
    }

    @Override
    protected MyQueue getInstanceSizeTwo() {
        return new StackQueue(2);
    }
}