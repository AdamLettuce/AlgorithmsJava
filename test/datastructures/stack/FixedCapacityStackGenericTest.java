package datastructures.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class FixedCapacityStackGenericTest {

    @Test
    public void isEmpty_true() {
        //given
        FixedCapacityStackGeneric<String> instance = new FixedCapacityStackGeneric<>(1);
        //when
        boolean actual = instance.isEmpty();
        //then
        assertTrue(actual);
    }

    @Test
    public void isEmpty_push_false() {
        //given
        FixedCapacityStackGeneric<Integer> instance = new FixedCapacityStackGeneric<>(1);
        instance.push(1);
        //when
        boolean actual = instance.isEmpty();
        //then
        assertFalse(actual);
    }

    @Test
    public void size_0() {
        //given
        FixedCapacityStackGeneric<Integer> instance = new FixedCapacityStackGeneric<>(1);
        //when
        int actual = instance.size();
        //then
        assertEquals(0, actual);
    }

    @Test
    public void size_1() {
        //given
        FixedCapacityStackGeneric<Integer> instance = new FixedCapacityStackGeneric<>(1);
        //when
        instance.push(1);
        int actual = instance.size();
        //then
        assertEquals(1, actual);
    }

    @Test
    public void pop_emptyStack() {
        //given
        FixedCapacityStackGeneric<Integer> instance = new FixedCapacityStackGeneric<>(1);
        //when
        Integer actual = instance.pop();
        //then
        assertNull(actual);
    }

    @Test
    public void pop() {
        //given
        FixedCapacityStackGeneric<Integer> instance = new FixedCapacityStackGeneric<>(1);
        //when
        instance.push(1);
        Integer actual = instance.pop();
        //then
        assertEquals(Integer.valueOf(1), actual);
    }

    @Test
    public void pop_pushedTwoElements_popedSecondFirst() {
        //given
        FixedCapacityStackGeneric<Integer> instance = new FixedCapacityStackGeneric<>(2);
        //when
        instance.push(1);
        instance.push(2);
        Integer actual = instance.pop();
        //then
        assertEquals(Integer.valueOf(2), actual);
    }
}