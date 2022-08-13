package datastructures.list.signlelinked;


import datastructures.list.signlelinked.SingleLinkedListTwoPointersAdvancedMethods.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SingleLinkedListTwoPointersAdvancedMethodsTest {

    @Test
    public void testGet1() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = listWithThreeElements();
        assertEquals(3, (int) list.get(0));
    }

    @Test
    public void testGet2() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = listWithThreeElements();
        assertEquals(2,(int)list.get(1));
    }

    @Test
    public void testGet3() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = listWithThreeElements();
        assertEquals(1,(int)list.get(2));
    }
    
    @Test
    public void testEmpty_noElements_true() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testEmpty_oneElement_false() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        list.addBegin(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testAddFromBegin() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        list.addBegin(123);
        assertEquals(1,list.size());
        assertEquals(123,(int)list.get(0));
    }

    @Test
    public void testAddFromBeginTwoElements() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        list.addBegin(123);
        list.addBegin(456);
        assertEquals(2,list.size());
        assertEquals(456,(int)list.get(0));
        assertEquals(123,(int)list.get(1));
    }

    @Test
    public void testAddFromEndTwoElements() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        list.addEnd(123);
        list.addEnd(456);
        assertEquals(2,list.size());
        assertEquals(123,(int)list.get(0));
        assertEquals(456,(int)list.get(1));
    }

    @Test
    public void testHasOneElement_empty_false() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        assertFalse(list.hasOneElement());
    }

    @Test
    public void testHasOneElement_oneElement_true() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        list.addBegin(123);
        assertTrue(list.hasOneElement());
    }

    @Test
    public void testHasOneElement_twoElements_false() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        list.addBegin(123);
        list.addBegin(456);
        assertFalse(list.hasOneElement());
    }

    @Test
    public void testPrint() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        list.addBegin(1);
        list.addBegin(2);
        list.addBegin(3);
        list.addBegin(4);
        assertEquals("4, 3, 2, 1", list.toString());
    }

    @Test
    public void removeBegin_emptyList_null() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        assertNull(list.removeBegin());
    }

    @Test
    public void removeBegin_oneElement_notNull() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        list.addEnd(1);
        assertEquals(1, (int) list.removeBegin());
        assertTrue(list.isEmpty());
    }

    @Test
    public void removeBegin_twoElements_notNull() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        list.addEnd(1);
        list.addEnd(2);
        assertEquals(1, (int) list.removeBegin());
        assertFalse(list.isEmpty());
        assertEquals(2, (int) list.removeBegin());
        assertTrue(list.isEmpty());
    }

    @Test
    public void removeEnd_empty_null() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        assertNull(list.removeEnd());
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void removeEnd_oneElement_notNull() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        list.addEnd(1);
        assertEquals(1, (int) list.removeEnd());
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void removeEnd_twoElements_notNull() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
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
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        list.addEnd(1);
        list = list.reverseImmutable();
        assertEquals(1, (int) list.get(0));
    }

    @Test
    public void reverse_twoElements() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        list.addEnd(1);
        list.addEnd(2);
        list = list.reverseImmutable();
        assertEquals(2, (int) list.get(0));
        assertEquals(1, (int) list.get(1));
    }

    @Test
    public void reverse_threeElements() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
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
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        list.reverseMutable();
    }

    @Test
    public void reverseMutable_oneElement() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        list.addEnd(1);
        list.reverseMutable();
        assertEquals(1, (int) list.get(0));
    }

    @Test
    public void reverseMutable_twoElements() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        list.addEnd(1);
        list.addEnd(2);
        list.reverseMutable();
        assertEquals(2, (int) list.get(0));
        assertEquals(1, (int) list.get(1));
    }

    @Test
    public void reverseMutable_threeElements() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> list = new SingleLinkedListTwoPointersAdvancedMethods<>();
        list.addEnd(1);
        list.addEnd(2);
        list.addEnd(3);
        list.reverseMutable();
        assertEquals(3, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(1, (int) list.get(2));
    }

    private SingleLinkedListTwoPointersAdvancedMethods<Integer> listWithThreeElements() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> result = new SingleLinkedListTwoPointersAdvancedMethods<>();
        result.addBegin(1);
        result.addBegin(2);
        result.addBegin(3);
        return result;
    }

    @Test
    public void hasCycle_emptyList_noCycle() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> result = new SingleLinkedListTwoPointersAdvancedMethods<>();
        assertFalse(result.hasCycle());
    }

    @Test
    public void hasCycle_oneElementOnList_noCycle() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> result = new SingleLinkedListTwoPointersAdvancedMethods<>();
        result.addBegin(1);
        assertFalse(result.hasCycle());
    }

    @Test
    public void hasCycle_firstRefersToItself_hasCycle() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> result = new SingleLinkedListTwoPointersAdvancedMethods<>();

        Node<Integer> first = new Node<>(1);
        first.next = first;

        result.addBegin(first);
        assertTrue(result.hasCycle());
    }

    @Test
    public void hasCycle_secondRefersToFirst_hasCycle() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> result = new SingleLinkedListTwoPointersAdvancedMethods<>();

        Node<Integer> first = new Node<>(1);
        result.addBegin(first);

        Node<Integer> second = new Node<>(2);
        second.next = first;

        result.addEnd(second);
        assertTrue(result.hasCycle());
    }

    @Test
    public void hasCycle_thirdRefersToFirst_hasCycle() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> result = new SingleLinkedListTwoPointersAdvancedMethods<>();

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
        SingleLinkedListTwoPointersAdvancedMethods<Integer> result = new SingleLinkedListTwoPointersAdvancedMethods<>();

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
        SingleLinkedListTwoPointersAdvancedMethods<Integer> result = listWithThreeElements();
        assertFalse(result.hasCycle());
    }

    @Test
    public void hasCycle_fourthRefersToFirst_hasCycle() {
        SingleLinkedListTwoPointersAdvancedMethods<Integer> result = new SingleLinkedListTwoPointersAdvancedMethods<>();

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