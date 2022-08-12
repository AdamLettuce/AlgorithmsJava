package datastructures.list;


import org.junit.Test;

import static org.junit.Assert.*;

public class SingleLinkedListTest {

    @Test
    public void testGet1() {
        SingleLinkedListComplex<Integer> list = listWithThreeElements();
        assertEquals(3, (int) list.get(0));
    }

    @Test
    public void testGet2() {
        SingleLinkedListComplex<Integer> list = listWithThreeElements();
        assertEquals(2,(int)list.get(1));
    }

    @Test
    public void testGet3() {
        SingleLinkedListComplex<Integer> list = listWithThreeElements();
        assertEquals(1,(int)list.get(2));
    }
    
    @Test
    public void testEmpty_noElements_true() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testEmpty_oneElement_false() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        list.addBegin(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testAddFromBegin() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        list.addBegin(123);
        assertEquals(1,list.size());
        assertEquals(123,(int)list.get(0));
    }

    @Test
    public void testAddFromBeginTwoElements() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        list.addBegin(123);
        list.addBegin(456);
        assertEquals(2,list.size());
        assertEquals(456,(int)list.get(0));
        assertEquals(123,(int)list.get(1));
    }

    @Test
    public void testAddFromEndTwoElements() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        list.addEnd(123);
        list.addEnd(456);
        assertEquals(2,list.size());
        assertEquals(123,(int)list.get(0));
        assertEquals(456,(int)list.get(1));
    }

    @Test
    public void testHasOneElement_empty_false() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        assertFalse(list.hasOneElement());
    }

    @Test
    public void testHasOneElement_oneElement_true() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        list.addBegin(123);
        assertTrue(list.hasOneElement());
    }

    @Test
    public void testHasOneElement_twoElements_false() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        list.addBegin(123);
        list.addBegin(456);
        assertFalse(list.hasOneElement());
    }

    @Test
    public void testPrint() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        list.addBegin(1);
        list.addBegin(2);
        list.addBegin(3);
        list.addBegin(4);
        assertEquals("4, 3, 2, 1", list.toString());
    }

    @Test
    public void removeBegin_emptyList_null() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        assertNull(list.removeBegin());
    }

    @Test
    public void removeBegin_oneElement_notNull() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        list.addEnd(1);
        assertEquals(1, (int) list.removeBegin());
        assertTrue(list.isEmpty());
    }

    @Test
    public void removeBegin_twoElements_notNull() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        list.addEnd(1);
        list.addEnd(2);
        assertEquals(1, (int) list.removeBegin());
        assertFalse(list.isEmpty());
        assertEquals(2, (int) list.removeBegin());
        assertTrue(list.isEmpty());
    }

    @Test
    public void removeEnd_empty_null() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        assertNull(list.removeEnd());
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void removeEnd_oneElement_notNull() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        list.addEnd(1);
        assertEquals(1, (int) list.removeEnd());
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void removeEnd_twoElements_notNull() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
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
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        list.addEnd(1);
        list = list.reverseImmutable();
        assertEquals(1, (int) list.get(0));
    }

    @Test
    public void reverse_twoElements() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        list.addEnd(1);
        list.addEnd(2);
        list = list.reverseImmutable();
        assertEquals(2, (int) list.get(0));
        assertEquals(1, (int) list.get(1));
    }

    @Test
    public void reverse_threeElements() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
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
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        list.reverseMutable();
    }

    @Test
    public void reverseMutable_oneElement() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        list.addEnd(1);
        list.reverseMutable();
        assertEquals(1, (int) list.get(0));
    }

    @Test
    public void reverseMutable_twoElements() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        list.addEnd(1);
        list.addEnd(2);
        list.reverseMutable();
        assertEquals(2, (int) list.get(0));
        assertEquals(1, (int) list.get(1));
    }

    @Test
    public void reverseMutable_threeElements() {
        SingleLinkedListComplex<Integer> list = new SingleLinkedListComplex<>();
        list.addEnd(1);
        list.addEnd(2);
        list.addEnd(3);
        list.reverseMutable();
        assertEquals(3, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(1, (int) list.get(2));
    }

    private SingleLinkedListComplex<Integer> listWithThreeElements() {
        SingleLinkedListComplex<Integer> result = new SingleLinkedListComplex<>();
        result.addBegin(1);
        result.addBegin(2);
        result.addBegin(3);
        return result;
    }

    @Test
    public void hasCycle_emptyList_noCycle() {
        SingleLinkedListComplex<Integer> result = new SingleLinkedListComplex<>();
        assertFalse(result.hasCycle());
    }

    @Test
    public void hasCycle_oneElementOnList_noCycle() {
        SingleLinkedListComplex<Integer> result = new SingleLinkedListComplex<>();
        result.addBegin(1);
        assertFalse(result.hasCycle());
    }

    @Test
    public void hasCycle_firstRefersToItself_hasCycle() {
        SingleLinkedListComplex<Integer> result = new SingleLinkedListComplex<>();

        Node<Integer> first = new Node<>(1);
        first.next = first;

        result.addBegin(first);
        assertTrue(result.hasCycle());
    }

    @Test
    public void hasCycle_secondRefersToFirst_hasCycle() {
        SingleLinkedListComplex<Integer> result = new SingleLinkedListComplex<>();

        Node<Integer> first = new Node<>(1);
        result.addBegin(first);

        Node<Integer> second = new Node<>(2);
        second.next = first;

        result.addEnd(second);
        assertTrue(result.hasCycle());
    }

    @Test
    public void hasCycle_thirdRefersToFirst_hasCycle() {
        SingleLinkedListComplex<Integer> result = new SingleLinkedListComplex<>();

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
        SingleLinkedListComplex<Integer> result = new SingleLinkedListComplex<>();

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
        SingleLinkedListComplex<Integer> result = listWithThreeElements();
        assertFalse(result.hasCycle());
    }

    @Test
    public void hasCycle_fourthRefersToFirst_hasCycle() {
        SingleLinkedListComplex<Integer> result = new SingleLinkedListComplex<>();

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