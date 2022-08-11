package datastructures.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ArrayQueueTest {

    @Test
    public void enQueue_oneElement_peekReturnsIt() {
        MyQueue instance = getInstanceSizeOne();
        instance.enQueue(1);
        assertEquals(1,instance.peek());
    }

    @Test
    public void enQueue_oneElement_deQueueReturnsIt() {
        MyQueue instance = getInstanceSizeOne();
        instance.enQueue(1);
        assertEquals(1,instance.deQueue());
        assertEquals(-1,instance.peek());
    }

    @Test
    public void enQueue_twoElementsMaxOneElement_secondNotenQueued() {
        MyQueue instance = getInstanceSizeOne();
        instance.enQueue(1);
        instance.enQueue(2);
        assertEquals(1,instance.peek());
    }

    @Test
    public void enQueue_twoElements_deQueueOneElement_enQueueOneElement() {
        MyQueue instance = getInstanceSizeTwo();
        instance.enQueue(1);
        instance.enQueue(2);
        instance.deQueue();
        instance.enQueue(3);
        assertEquals(2,instance.deQueue());
    }

    @Test
    public void deQueue_emptyQueue_null() {
        MyQueue instance = getInstanceSizeOne();
        assertEquals(-1,instance.deQueue());
    }

    @Test
    public void peek_emptyQueue_null() {
        MyQueue instance = getInstanceSizeOne();
        assertEquals(-1,instance.peek());
    }

    @Test
    public void isFull_false() {
        MyQueue instance = getInstanceSizeOne();
        assertFalse(instance.isFull());
    }

    @Test
    public void isFull_true() {
        MyQueue instance = getInstanceSizeOne();
        instance.enQueue(1);
        assertTrue(instance.isFull());
    }

    @Test
    public void isEmpty_true() {
        MyQueue instance = getInstanceSizeOne();
        assertTrue(instance.isEmpty());
    }

    @Test
    public void isEmpty_false() {
        MyQueue instance = getInstanceSizeOne();
        instance.enQueue(1);
        assertFalse(instance.isEmpty());
    }

    @Test
    public void isEmpty_enQueuedeQueue_true() {
        MyQueue instance = getInstanceSizeOne();
        instance.enQueue(1);
        instance.deQueue();
        assertTrue(instance.isEmpty());
    }

    protected MyQueue getInstanceSizeOne() {
        return new FixedSizeQueue(1);
    }

    protected MyQueue getInstanceSizeTwo() {
        return new FixedSizeQueue(2);
    }
}