package datastructures.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ArrayQueueTest {

    @Test
    public void enqueue_oneElement_peekReturnsIt() {
        Queue instance = getInstanceSizeOne();
        instance.enqueue(1);
        assertEquals(Integer.valueOf(1),instance.peek());
    }

    @Test
    public void enqueue_oneElement_dequeueReturnsIt() {
        Queue instance = getInstanceSizeOne();
        instance.enqueue(1);
        assertEquals(Integer.valueOf(1),instance.dequeue());
        assertNull(instance.peek());
    }

    @Test
    public void enqueue_twoElementsMaxOneElement_secondNotEnqueued() {
        Queue instance = getInstanceSizeOne();
        instance.enqueue(1);
        instance.enqueue(2);
        assertEquals(Integer.valueOf(1),instance.peek());
    }

    @Test
    public void enqueue_twoElements_dequeueOneElement_enqueueOneElement() {
        Queue instance = getInstanceSizeTwo();
        instance.enqueue(1);
        instance.enqueue(2);
        instance.dequeue();
        instance.enqueue(3);
        assertEquals(Integer.valueOf(2),instance.dequeue());
    }

    @Test
    public void dequeue_emptyQueue_null() {
        Queue instance = getInstanceSizeOne();
        assertNull(instance.dequeue());
    }

    @Test
    public void peek_emptyQueue_null() {
        Queue instance = getInstanceSizeOne();
        assertNull(instance.peek());
    }

    @Test
    public void isFull_false() {
        Queue instance = getInstanceSizeOne();
        assertFalse(instance.isFull());
    }

    @Test
    public void isFull_true() {
        Queue instance = getInstanceSizeOne();
        instance.enqueue(1);
        assertTrue(instance.isFull());
    }

    @Test
    public void isEmpty_true() {
        Queue instance = getInstanceSizeOne();
        assertTrue(instance.isEmpty());
    }

    @Test
    public void isEmpty_false() {
        Queue instance = getInstanceSizeOne();
        instance.enqueue(1);
        assertFalse(instance.isEmpty());
    }

    @Test
    public void isEmpty_enqueueDequeue_true() {
        Queue instance = getInstanceSizeOne();
        instance.enqueue(1);
        instance.dequeue();
        assertTrue(instance.isEmpty());
    }

    protected Queue getInstanceSizeOne() {
        return new ArrayQueue(1);
    }

    protected Queue getInstanceSizeTwo() {
        return new ArrayQueue(2);
    }
}