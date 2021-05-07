package datastructures.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class FixedCapacityStackOfStringsTest {

    @Test
    public void isEmpty_true() {
        //given
        FixedCapacityStackOfStrings instance = getInstance(1);
        //when
        boolean actual = instance.isEmpty();
        //then
        assertTrue(actual);
    }

    @Test
    public void isEmpty_push_false() {
        //given
        FixedCapacityStackOfStrings instance = getInstance(1);
        instance.push("A");
        //when
        boolean actual = instance.isEmpty();
        //then
        assertFalse(actual);
    }

    @Test
    public void size_0() {
        //given
        FixedCapacityStackOfStrings instance = getInstance(1);
        //when
        int actual = instance.size();
        //then
        assertEquals(0, actual);
    }

    @Test
    public void size_1() {
        //given
        FixedCapacityStackOfStrings instance = getInstance(1);
        //when
        instance.push("A");
        int actual = instance.size();
        //then
        assertEquals(1, actual);
    }

    @Test
    public void push_notToMuch_true() {
        //given
        FixedCapacityStackOfStrings instance = getInstance(1);
        //when
        boolean actual = instance.push("A");
        //then
        assertTrue(actual);
    }

    @Test
    public void push_toMuch_false() {
        //given
        FixedCapacityStackOfStrings instance = getInstance(1);
        //when
        instance.push("A");
        boolean actual = instance.push("B");
        //then
        assertFalse(actual);
    }

    @Test
    public void pop_emptyStack() {
        //given
        FixedCapacityStackOfStrings instance = getInstance(1);
        //when
        String actual = instance.pop();
        //then
        assertNull(actual);
    }

    @Test
    public void pop() {
        //given
        FixedCapacityStackOfStrings instance = getInstance(1);
        //when
        instance.push("A");
        String actual = instance.pop();
        //then
        assertEquals("A",actual);
    }

    private FixedCapacityStackOfStrings getInstance(int i) {
        return new FixedCapacityStackOfStrings(i);
    }

    @Test
    public void pop_pushedTwoElements_popedSecondFirst() {
        //given
        FixedCapacityStackOfStrings instance = getInstance(2);
        //when
        instance.push("A");
        instance.push("B");
        String actual = instance.pop();
        //then
        assertEquals("B",actual);
    }
}