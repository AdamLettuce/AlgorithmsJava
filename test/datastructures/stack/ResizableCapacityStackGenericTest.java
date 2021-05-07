package datastructures.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ResizableCapacityStackGenericTest {


    @Test
    public void size_() {
        //given
        ResizableCapacityStackGeneric<Integer> instance = new ResizableCapacityStackGeneric<>(1);
        //when
        instance.push(1);
        instance.push(2);
        instance.push(3);
        instance.push(4);
        int actual = instance.size();
        //then
        assertEquals(4, actual);
    }


    @Test
    public void size_16() {
        //given
        ResizableCapacityStackGeneric<Integer> instance = new ResizableCapacityStackGeneric<>(1);
        //when
        instance.push(1);
        instance.push(2);
        instance.push(3);
        instance.push(4);

        instance.push(1);
        instance.push(2);
        instance.push(3);
        instance.push(4);

        instance.push(1);
        instance.push(2);
        instance.push(3);
        instance.push(4);

        instance.push(1);
        instance.push(2);
        instance.push(3);
        instance.push(4);
        int actual = instance.size();
        //then
        assertEquals(16, actual);

        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();

//        assertEquals(16, instance.maxSize());

        instance.pop();

        assertEquals(4, instance.size());

        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();

        instance.push(1);

//        System.out.println(instance.maxSize());



    }

}