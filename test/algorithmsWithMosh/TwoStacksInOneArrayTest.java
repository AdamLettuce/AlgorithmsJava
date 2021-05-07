package algorithmsWithMosh;

import datastructures.stack.TwoStacksInOneArray;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoStacksInOneArrayTest {

    @Test
    public void pushFirst_isNotEmpty() {
        TwoStacksInOneArray instance = new TwoStacksInOneArray(2);
        instance.pushFirst(1);
        assertFalse(instance.isEmptyFirst());
        assertTrue(instance.isFullFirst());
    }

    @Test
    public void pushFirstTwoElements_FirstFullSecondEmpty() {
        TwoStacksInOneArray instance = new TwoStacksInOneArray(2);
        instance.pushFirst(1);
        instance.pushFirst(2);
        assertTrue(instance.isFullFirst());
        assertTrue(instance.isEmptySecond());
    }

    @Test
    public void pushSecondTwoElements_SecondullFirstEmpty() {
        TwoStacksInOneArray instance = new TwoStacksInOneArray(2);
        instance.pushSecond(1);
        instance.pushSecond(2);
        assertTrue(instance.isFullSecond());
        assertTrue(instance.isEmptyFirst());
    }

    @Test
    public void pushFirstOneElementSecondOneElement_BothStacksFull() {
        TwoStacksInOneArray instance = new TwoStacksInOneArray(2);
        instance.pushFirst(1);
        instance.pushSecond(2);
        assertTrue(instance.isFullFirst());
        assertTrue(instance.isFullSecond());
    }

    @Test
    public void pushSecond_isNotEmpty() {
        TwoStacksInOneArray instance = new TwoStacksInOneArray(2);
        instance.pushSecond(2);
        assertFalse(instance.isEmptySecond());
    }

    @Test
    public void popFirst_isNotEmpty() {
        TwoStacksInOneArray instance = new TwoStacksInOneArray(2);
        instance.pushFirst(2);
        instance.pushFirst(1);
        assertEquals(Integer.valueOf(1),instance.popFirst());
        assertEquals(Integer.valueOf(2),instance.popFirst());
    }

    @Test
    public void popSecond_isNotEmpty() {
        TwoStacksInOneArray instance = new TwoStacksInOneArray(2);
        instance.pushSecond(2);
        instance.pushSecond(1);
        assertEquals(Integer.valueOf(1),instance.popSecond());
        assertEquals(Integer.valueOf(2),instance.popSecond());
    }
}