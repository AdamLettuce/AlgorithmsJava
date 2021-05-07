package algorithmsWithMosh;

import datastructures.queue.StackWithMinimum;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackWithMinimumTest {
    @Test
    public void pushOne_popOne() {
        StackWithMinimum instance = new StackWithMinimum();
        assertTrue(instance.push(1));
        assertEquals(Integer.valueOf(1),instance.pop());
    }

    @Test
    public void pushOne_popTwo() {
        StackWithMinimum instance = new StackWithMinimum();
        assertTrue(instance.push(1));
        assertEquals(Integer.valueOf(1),instance.pop());
        assertEquals(null,instance.pop());
    }

    @Test
    public void pushTwo_popTwo() {
        StackWithMinimum instance = new StackWithMinimum();
        assertTrue(instance.push(1));
        assertTrue(instance.push(2));
        assertEquals(Integer.valueOf(2),instance.pop());
        assertEquals(Integer.valueOf(1),instance.pop());
    }

    @Test
    public void pushThree_minBottom() {
        StackWithMinimum instance = new StackWithMinimum();
        assertTrue(instance.push(1));
        assertTrue(instance.push(2));
        assertTrue(instance.push(3));
        assertEquals(Integer.valueOf(1),instance.min());
    }

    @Test
    public void pushThree_minTop() {
        StackWithMinimum instance = new StackWithMinimum();
        assertTrue(instance.push(3));
        assertTrue(instance.push(2));
        assertTrue(instance.push(1));
        assertEquals(Integer.valueOf(1),instance.min());
    }

    @Test
    public void pushThree_minTopPopOneFromTop() {
        StackWithMinimum instance = new StackWithMinimum();
        assertTrue(instance.push(3));
        assertTrue(instance.push(2));
        assertTrue(instance.push(1));
        instance.pop();
        assertEquals(Integer.valueOf(2),instance.min());
    }

    @Test
    public void pushThree_minTopPopTwoFromTop() {
        StackWithMinimum instance = new StackWithMinimum();
        assertTrue(instance.push(3));
        assertTrue(instance.push(2));
        assertTrue(instance.push(1));
        instance.pop();
        instance.pop();
        assertEquals(Integer.valueOf(3),instance.min());
    }

    @Test
    public void pushFour_popOne() {
        StackWithMinimum instance = new StackWithMinimum();
        assertTrue(instance.push(10));
        assertTrue(instance.push(9));
        assertTrue(instance.push(11));
        assertTrue(instance.push(7));
        instance.pop();
        assertEquals(Integer.valueOf(9),instance.min());
    }
}