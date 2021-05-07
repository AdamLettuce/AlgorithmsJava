package datastructures.queue;

public class StackQueueTest extends ArrayQueueTest {

    @Override
    protected Queue getInstanceSizeOne() {
        return new StackQueue(1);
    }

    @Override
    protected Queue getInstanceSizeTwo() {
        return new StackQueue(2);
    }
}