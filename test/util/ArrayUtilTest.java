package util;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by adam on 11/03/2018.
 */
public class ArrayUtilTest {

    @Test
    public void prefixSum_null() {
        //given
        ArrayUtil instance = new ArrayUtil();
        //when
        int[] actual = instance.prefixSum(null);
        //then
        assertNull(actual);
    }

    @Test
    public void prefixSum_oneElement() {
        //given
        ArrayUtil instance = new ArrayUtil();
        //when
        int[] actual = instance.prefixSum(new int[]{1});
        //then
        assertEquals(1,actual[0]);
    }

    @Test
    public void prefixSum_twoElements() {
        //given
        ArrayUtil instance = new ArrayUtil();
        //when
        int[] actual = instance.prefixSum(new int[]{1,2});
        //then
        assertEquals(1,actual[0]);
        assertEquals(3,actual[1]);
    }

    @Test
    public void sliceSum_9() {
        //given
        ArrayUtil instance = new ArrayUtil();
        //when
        int actual = instance.sliceSum(new int[]{1,2,3,4},1,3);
        //then
        assertEquals(9,actual);
    }

    @Test
    public void sliceSum_All() {
        //given
        ArrayUtil instance = new ArrayUtil();
        //when
        int actual = instance.sliceSum(new int[]{1,2,3,4},0,3);
        //then
        assertEquals(10,actual);
    }

}