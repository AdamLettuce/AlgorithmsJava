package datastructures.queue;

public class LinkwsListQueueTest extends ArrayQueueTest {

    @Override
    protected MyQueue getInstanceSizeOne() {
        return new LinkedListQueue(1);
    }

    @Override
    protected MyQueue getInstanceSizeTwo() {
        return new LinkedListQueue(2);
    }
}