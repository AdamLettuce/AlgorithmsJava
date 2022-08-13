package datastructures.list.signlelinked;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleLinkedListSimpleTest {

    @Test
    public void addBegin() {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        //when
        list.addBegin(1);
        list.addBegin(2);
        //then
        assertEquals(Integer.valueOf(2), list.get(0));
    }

    @Test
    public void addAt_emptyListNegativePosition() {
        addAt_emptyList(-1);
    }

    @Test
    public void addAt_emptyListZeroPosition() {
        addAt_emptyList(0);
    }

    @Test
    public void addAt_emptyListPositivePosition() {
        addAt_emptyList(1);
    }

    private void addAt_emptyList(int position) {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        //when
        list.addAt(position, 2);
        //then
        assertEquals(Integer.valueOf(2), list.get(0));
    }

    @Test
    public void addAt_oneElementListNegativePosition() {
        addAt_oneElementList(-1, 2, 1);
    }

    @Test
    public void addAt_oneElementListZeroPosition() {
        //given
        addAt_oneElementList(0, 2, 1);
    }

    @Test
    public void addAt_oneElementListPositivePosition() {
        //given
        addAt_oneElementList(1, 1, 2);
    }

    private void addAt_oneElementList(int position, int firstElementValue, int secondElementValue) {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        list.addBegin(1);
        //when
        list.addAt(position, 2);
        //then
        assertEquals(Integer.valueOf(firstElementValue), list.get(0));
        assertEquals(Integer.valueOf(secondElementValue), list.get(1));
    }

    @Test
    public void removeBegin_emptyList() {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        //when
        Integer result = list.removeBegin();
        //then
        assertEquals(Integer.valueOf(-1), result);
    }

    @Test
    public void removeBegin_oneElementList() {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        list.addBegin(1);
        //when
        Integer result = list.removeBegin();
        //then
        assertEquals(Integer.valueOf(1), result);
    }

    @Test
    public void removeBegin_twoElementsList() {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        list.addBegin(1);
        list.addBegin(2);
        //when
        Integer result = list.removeBegin();
        //then
        assertEquals(Integer.valueOf(2), result);
    }

    @Test
    public void isEmpty_emptyList() {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        //when
        //then
        assertTrue(list.isEmpty());
    }

    @Test
    public void isEmpty_notEmptyList() {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        //when
        list.addBegin(1);
        //then
        assertFalse(list.isEmpty());
    }

    @Test
    public void size_emptyList() {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        //when
        //then
        assertEquals(Integer.valueOf(0),Integer.valueOf(list.size()));
    }

    @Test
    public void size_oneElementList() {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        list.addBegin(1);
        //when
        //then
        assertEquals(Integer.valueOf(1),Integer.valueOf(list.size()));
    }

    @Test
    public void size_twoElementsList() {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        list.addBegin(1);
        list.addBegin(2);
        //when
        //then
        assertEquals(Integer.valueOf(2),Integer.valueOf(list.size()));
    }

    @Test
    public void get_emptyList_negativePosition() {
        get_emptyList(-1);
    }

    @Test
    public void get_emptyList_zeroPosition() {
        get_emptyList(0);
    }

    @Test
    public void get_emptyList_positivePosition() {
        get_emptyList(1);
    }

    private void get_emptyList(Integer i) {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        //when
        Integer result = list.get(i);
        //then
        assertEquals(Integer.valueOf(-1),result);
    }

    @Test
    public void get_oneElementList_negativePosition() {
        get_oneElementList(-1, -1);
    }

    @Test
    public void get_oneElementList_zeroPosition() {
        get_oneElementList(0, 10);
    }

    @Test
    public void get_oneElementList_positivePosition() {
        get_oneElementList(1, -1);
    }

    private void get_oneElementList(Integer position, Integer expected) {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        list.addBegin(10);
        //when
        Integer result = list.get(position);
        //then
        assertEquals(Integer.valueOf(expected),result);
    }

    @Test
    public void get_twoElementsList_negativePosition() {
        get_twoElementsList(-1,-1);
    }

    @Test
    public void get_twoElementsList_zeroPosition() {
        get_twoElementsList(0,10);
    }

    @Test
    public void get_twoElementsList_positionOne() {
        get_twoElementsList(1,40);
    }

    @Test
    public void get_twoElementsList_positionTwo() {
        get_twoElementsList(2,-1);
    }

    private void get_twoElementsList(Integer position, Integer expected) {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        list.addBegin(40);
        list.addBegin(10);
        //when
        Integer result = list.get(position);
        //then
        assertEquals(Integer.valueOf(expected),result);
    }

    @Test
    public void testToString_emptyList() {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        //when
        String s = list.toString();
        //then
        assertEquals("[]",s);
    }

    @Test
    public void testToString_oneElementList() {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        list.addBegin(1);
        //when
        String s = list.toString();
        //then
        assertEquals("[1]",s);
    }

    @Test
    public void testToString_twoElementsList() {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        list.addBegin(2);
        list.addBegin(1);
        //when
        String s = list.toString();
        //then
        assertEquals("[1, 2]",s);
    }

    @Test
    public void testToString_threeElementsList() {
        //given
        SingleLinkedListSimple list = new SingleLinkedListSimple();
        list.addBegin(3);
        list.addBegin(2);
        list.addBegin(1);
        //when
        String s = list.toString();
        //then
        assertEquals("[1, 2, 3]",s);
    }
}