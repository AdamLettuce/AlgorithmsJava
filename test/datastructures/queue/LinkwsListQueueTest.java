package datastructures.queue;

public class LinkwsListQueueTest extends ArrayQueueTest {

    @Override
    protected Queue getInstanceSizeOne() {
        return new LinkedListQueue(1);
    }

    @Override
    protected Queue getInstanceSizeTwo() {
        return new LinkedListQueue(2);
    }
}