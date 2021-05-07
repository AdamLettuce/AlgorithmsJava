package datastructures.list;


import org.junit.Test;

import static org.junit.Assert.*;

public class MyListTest {

    @Test
    public void testGet1() {
        MyList<Integer> list = listWithThreeElements();
        assertEquals(3, (int) list.get(0));
    }

    @Test
    public void testGet2() {
        MyList<Integer> list = listWithThreeElements();
        assertEquals(2,(int)list.get(1));
    }

    @Test
    public void testGet3() {
        MyList<Integer> list = listWithThreeElements();
        assertEquals(1,(int)list.get(2));
    }
    
    @Test
    public void testEmpty_noElements_true() {
        MyList<Integer> list = new MyList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testEmpty_oneElement_false() {
        MyList<Integer> list = new MyList<>();
        list.addBegin(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testAddFromBegin() {
        MyList<Integer> list = new MyList<>();
        list.addBegin(123);
        assertEquals(1,list.size());
        assertEquals(123,(int)list.get(0));
    }

    @Test
    public void testAddFromBeginTwoElements() {
        MyList<Integer> list = new MyList<>();
        list.addBegin(123);
        list.addBegin(456);
        assertEquals(2,list.size());
        assertEquals(456,(int)list.get(0));
        assertEquals(123,(int)list.get(1));
    }

    @Test
    public void testAddFromEndTwoElements() {
        MyList<Integer> list = new MyList<>();
        list.addEnd(123);
        list.addEnd(456);
        assertEquals(2,list.size());
        assertEquals(123,(int)list.get(0));
        assertEquals(456,(int)list.get(1));
    }

    @Test
    public void testHasOneElement_empty_false() {
        MyList<Integer> list = new MyList<>();
        assertFalse(list.hasOneElement());
    }

    @Test
    public void testHasOneElement_oneElement_true() {
        MyList<Integer> list = new MyList<>();
        list.addBegin(123);
        assertTrue(list.hasOneElement());
    }

    @Test
    public void testHasOneElement_twoElements_false() {
        MyList<Integer> list = new MyList<>();
        list.addBegin(123);
        list.addBegin(456);
        assertFalse(list.hasOneElement());
    }

    @Test
    public void testPrint() {
        MyList<Integer> list = new MyList<>();
        list.addBegin(1);
        list.addBegin(2);
        list.addBegin(3);
        list.addBegin(4);
        assertEquals("4, 3, 2, 1", list.toString());
    }

    @Test
    public void removeBegin_emptyList_null() {
        MyList<Integer> list = new MyList<>();
        assertNull(list.removeBegin());
    }

    @Test
    public void removeBegin_oneElement_notNull() {
        MyList<Integer> list = new MyList<>();
        list.addEnd(1);
        assertEquals(1, (int) list.removeBegin());
        assertTrue(list.isEmpty());
    }

    @Test
    public void removeBegin_twoElements_notNull() {
        MyList<Integer> list = new MyList<>();
        list.addEnd(1);
        list.addEnd(2);
        assertEquals(1, (int) list.removeBegin());
        assertFalse(list.isEmpty());
        assertEquals(2, (int) list.removeBegin());
        assertTrue(list.isEmpty());
    }

    @Test
    public void removeEnd_empty_null() {
        MyList<Integer> list = new MyList<>();
        assertNull(list.removeEnd());
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void removeEnd_oneElement_notNull() {
        MyList<Integer> list = new MyList<>();
        list.addEnd(1);
        assertEquals(1, (int) list.removeEnd());
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void removeEnd_twoElements_notNull() {
        MyList<Integer> list = new MyList<>();
        list.addEnd(1);
        list.addEnd(2);
        assertEquals(2, (int) list.removeEnd());
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals(1, (int) list.removeEnd());
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void reverse_oneElement() {
        MyList<Integer> list = new MyList<>();
        list.addEnd(1);
        list = list.reverseImmutable();
        assertEquals(1, (int) list.get(0));
    }

    @Test
    public void reverse_twoElements() {
        MyList<Integer> list = new MyList<>();
        list.addEnd(1);
        list.addEnd(2);
        list = list.reverseImmutable();
        assertEquals(2, (int) list.get(0));
        assertEquals(1, (int) list.get(1));
    }

    @Test
    public void reverse_threeElements() {
        MyList<Integer> list = new MyList<>();
        list.addEnd(1);
        list.addEnd(2);
        list.addEnd(3);
        list = list.reverseImmutable();
        assertEquals(3, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(1, (int) list.get(2));
    }

    @Test
    public void reverseMutable_emptyList() {
        MyList<Integer> list = new MyList<>();
        list.reverseMutable();
    }

    @Test
    public void reverseMutable_oneElement() {
        MyList<Integer> list = new MyList<>();
        list.addEnd(1);
        list.reverseMutable();
        assertEquals(1, (int) list.get(0));
    }

    @Test
    public void reverseMutable_twoElements() {
        MyList<Integer> list = new MyList<>();
        list.addEnd(1);
        list.addEnd(2);
        list.reverseMutable();
        assertEquals(2, (int) list.get(0));
        assertEquals(1, (int) list.get(1));
    }

    @Test
    public void reverseMutable_threeElements() {
        MyList<Integer> list = new MyList<>();
        list.addEnd(1);
        list.addEnd(2);
        list.addEnd(3);
        list.reverseMutable();
        assertEquals(3, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(1, (int) list.get(2));
    }

    private MyList<Integer> listWithThreeElements() {
        MyList<Integer> result = new MyList<>();
        result.addBegin(1);
        result.addBegin(2);
        result.addBegin(3);
        return result;
    }

    @Test
    public void hasCycle_emptyList_noCycle() {
        MyList<Integer> result = new MyList<>();
        assertFalse(result.hasCycle());
    }

    @Test
    public void hasCycle_oneElementOnList_noCycle() {
        MyList<Integer> result = new MyList<>();
        result.addBegin(1);
        assertFalse(result.hasCycle());
    }

    @Test
    public void hasCycle_firstRefersToItself_hasCycle() {
        MyList<Integer> result = new MyList<>();

        Node<Integer> first = new Node<>(1);
        first.next = first;

        result.addBegin(first);
        assertTrue(result.hasCycle());
    }

    @Test
    public void hasCycle_secondRefersToFirst_hasCycle() {
        MyList<Integer> result = new MyList<>();

        Node<Integer> first = new Node<>(1);
        result.addBegin(first);

        Node<Integer> second = new Node<>(2);
        second.next = first;

        result.addEnd(second);
        assertTrue(result.hasCycle());
    }

    @Test
    public void hasCycle_thirdRefersToFirst_hasCycle() {
        MyList<Integer> result = new MyList<>();

        Node<Integer> first = new Node<>(1);
        result.addBegin(first);

        Node<Integer> second = new Node<>(2);
        result.addEnd(second);

        Node<Integer> third = new Node<>(2);
        third.next = first;
        result.addEnd(third);

        assertTrue(result.hasCycle());
    }

    @Test
    public void hasCycle_thirdRefersToSecond_hasCycle() {
        MyList<Integer> result = new MyList<>();

        Node<Integer> first = new Node<>(1);
        result.addBegin(first);

        Node<Integer> second = new Node<>(2);
        result.addEnd(second);

        Node<Integer> third = new Node<>(2);
        third.next = second;
        result.addEnd(third);

        assertTrue(result.hasCycle());
    }

    @Test
    public void hasCycle_threeElements_noCycle() {
        MyList<Integer> result = listWithThreeElements();
        assertFalse(result.hasCycle());
    }

    @Test
    public void hasCycle_fourthRefersToFirst_hasCycle() {
        MyList<Integer> result = new MyList<>();

        Node<Integer> first = new Node<>(1);
        result.addBegin(first);

        Node<Integer> second = new Node<>(2);
        result.addEnd(second);

        Node<Integer> third = new Node<>(3);
        result.addEnd(third);

        Node<Integer> fourth = new Node<>(2);
        fourth.next = first;
        result.addEnd(fourth);

        assertTrue(result.hasCycle());
    }
}