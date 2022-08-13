package datastructures.list.signlelinked;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleLinkedListSimpleAdvancedMethodsTest {

    @Test
    public void isEmpty_dontInsertBegin_true() {
        assertTrue(newInstance().isEmpty());
    }

    @Test
    public void isEmpty_insertBegin_false() {
        assertFalse(listWith_1().isEmpty());
    }

    @Test
    public void insertBegin_twoElements() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2();
        assertEquals(1, list.getAt(0));
        assertEquals(2, list.getAt(1));
    }

    @Test
    public void deleteBegin_oneElement() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1();
        assertEquals(list.deleteBegin(),1);
        assertTrue(list.isEmpty());
    }

    @Test
    public void deleteBegin_twoElements() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2();
        assertEquals(list.deleteBegin(),1);
        assertEquals(list.deleteBegin(),2);
        assertTrue(list.isEmpty());
    }

    @Test
    public void deleteAtWithExceptions_beforeList() {
        assertWithException(-1);
    }

    @Test
    public void deleteAtWithExceptions_first() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3();
        assertEquals(list.deleteAtWithExceptions(0),1);
    }

    @Test
    public void deleteAtWithExceptions_second() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3();
        assertEquals(list.deleteAtWithExceptions(1),2);
    }

    @Test
    public void deleteAtWithExceptions_third() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3();
        assertEquals(3, list.deleteAtWithExceptions(2));
    }

    @Test
    public void deleteAtWithExceptions_afterList() {
        assertWithException(3);
    }

    private void assertWithException(int i) {
        try {
            listWith_1_2_3().deleteAtWithExceptions(i);
        } catch (Exception e) {
            assertTrue(true);
            return;
        }
        fail();
    }

    @Test
    public void containsRecursive_emptyList_0_false() {
        SingleLinkedListSimpleAdvancedMethods list = newInstance();
        assertFalse(list.containsRecursive(0));
    }

    @Test
    public void containsRecursive_0_false() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3();
        assertFalse(list.containsRecursive(0));
    }

    @Test
    public void containsRecursive_1_true() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3();
        assertTrue(list.containsRecursive(1));
    }

    @Test
    public void containsRecursive_2_true() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3();
        assertTrue(list.containsRecursive(2));
    }

    @Test
    public void containsRecursive_3_true() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3();
        assertTrue(list.containsRecursive(3));
    }

    @Test
    public void containsIterative_emptyList_0_false() {
        SingleLinkedListSimpleAdvancedMethods list = newInstance();
        assertFalse(list.containsIterative(0));
    }

    @Test
    public void containsIterative_0_false() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3();
        assertFalse(list.containsIterative(0));
    }

    @Test
    public void containsIterative_1_true() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3();
        assertTrue(list.containsIterative(1));
    }

    @Test
    public void containsIterative_2_true() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3();
        assertTrue(list.containsIterative(2));
    }

    @Test
    public void containsIterative_3_true() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3();
        assertTrue(list.containsIterative(3));
    }

    @Test
    public void testToString_emptyList() {
        SingleLinkedListSimpleAdvancedMethods list = newInstance();
        assertEquals("()",list.toString());
    }

    @Test
    public void testToString_listWith_1() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1();
        assertEquals("(1)",list.toString());
    }

    @Test
    public void testToString_listWith_1_2() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2();
        assertEquals("(1,2)",list.toString());
    }

    @Test
    public void getAt_emptyList() {
        SingleLinkedListSimpleAdvancedMethods list = newInstance();
        try {
            list.getAt(0);
        } catch (Exception e) {
            assertTrue(true);
            return;
        }
        fail();
    }

    @Test
    public void getAt_listWith_1_beforeList() {
        assertEquals(listWith_1().getAt(-1),1);
    }

    @Test
    public void getAt_listWith_1_onList() {
        assertEquals(listWith_1().getAt(0), 1);
    }

    @Test
    public void getAt_listWith_1_afterList() {
        assertEquals(listWith_1().getAt(1), 1);
    }

    @Test
    public void getAt_listWith_1_2_get0() {
        assertEquals(listWith_1_2().getAt(0), 1);
    }

    @Test
    public void getAt_listWith_1_2_get1() {
        assertEquals(listWith_1_2().getAt(1), 2);
    }

    @Test
    public void getNodeAt_emptyList() {
        SingleLinkedListSimpleAdvancedMethods list = newInstance();
        try {
            list.getAt(0);
        } catch (Exception e) {
            assertTrue(true);
            return;
        }
        fail();
    }

    @Test
    public void getNodeAt_listWith_1_beforeList() {
        assertEquals(listWith_1().getAt(-1),1);
    }

    @Test
    public void getNodeAt_listWith_1_onList() {
        assertEquals(listWith_1().getAt(0), 1);
    }

    @Test
    public void getNodeAt_listWith_1_afterList() {
        assertEquals(listWith_1().getAt(1), 1);
    }

    @Test
    public void getNodeAt_listWith_1_2_get0() {
        assertEquals(listWith_1_2().getAt(0), 1);
    }

    @Test
    public void getNodeAt_listWith_1_2_get1() {
        assertEquals(listWith_1_2().getAt(1), 2);
    }

    @Test
    public void insertAt_minus1() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3();
        list.insertAt(4,-1);
        assertEquals(list.size(),4);
        assertEquals(list.getAt(0),4);
    }

    @Test
    public void insertAt_0() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3();
        list.insertAt(4,0);
        assertEquals(list.size(),4);
        assertEquals(list.getAt(0),4);
    }

    @Test
    public void insertAt_1() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3();
        list.insertAt(4,1);
        assertEquals(list.size(),4);
        assertEquals(list.getAt(1),4);
    }

    @Test
    public void insertAt_2() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3();
        list.insertAt(4,2);
        assertEquals(list.size(),4);
        assertEquals(list.getAt(2),4);
    }

    @Test
    public void insertAt_3() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3();
        list.insertAt(4,3);
        assertEquals(list.size(),4);
        assertEquals(list.getAt(3),4);
    }

    @Test
    public void insertEnd() {

        SingleLinkedListSimpleAdvancedMethods list = newInstance();
        list.insertEnd(1);
        list.insertEnd(2);
        assertEquals(list.getAt(0),1);
        assertEquals(list.getAt(1),2);
    }

    @Test
    public void testSize_emptyList_0() {
        assertEquals(newInstance().size(),0);
    }

    @Test
    public void testSize_listWithOne_1() {
        assertEquals(listWith_1().size(),1);
    }

    @Test
    public void testSize_listWithTwo_2() {
        assertEquals(listWith_1_2().size(),2);
    }

    @Test
    public void testSize_listWithThree_3() {
        assertEquals(listWith_1_2_3().size(),3);
    }

    @Test
    public void reverse_listWithTwoElements() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2();
        list.reverse();
        assertEquals(2,list.getAt(0));
        assertEquals(1,list.getAt(1));
    }

    @Test
    public void reverse_listWithThreElements() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3();
        list.reverse();
        assertEquals(3,list.getAt(0));
        assertEquals(2,list.getAt(1));
        assertEquals(1,list.getAt(2));
    }

    @Test
    public void reverse_listWithFourElements() {
        SingleLinkedListSimpleAdvancedMethods list = listWith_1_2_3_4();
        list.reverse();
        assertEquals(4,list.getAt(0));
        assertEquals(3,list.getAt(1));
        assertEquals(2,list.getAt(2));
        assertEquals(1,list.getAt(3));
    }

    private SingleLinkedListSimpleAdvancedMethods newInstance() {
        return new SingleLinkedListSimpleAdvancedMethods();
    }

    private SingleLinkedListSimpleAdvancedMethods listWith_1() {
        SingleLinkedListSimpleAdvancedMethods list = newInstance();
        list.insertBegin(1);
        return list;
    }

    private SingleLinkedListSimpleAdvancedMethods listWith_1_2() {
        SingleLinkedListSimpleAdvancedMethods list = newInstance();
        list.insertBegin(2);
        list.insertBegin(1);
        return list;
    }

    private SingleLinkedListSimpleAdvancedMethods listWith_1_2_3() {
        SingleLinkedListSimpleAdvancedMethods list = newInstance();
        list.insertBegin(3);
        list.insertBegin(2);
        list.insertBegin(1);
        return list;
    }

    private SingleLinkedListSimpleAdvancedMethods listWith_1_2_3_4() {
        SingleLinkedListSimpleAdvancedMethods list = newInstance();
        list.insertBegin(4);
        list.insertBegin(3);
        list.insertBegin(2);
        list.insertBegin(1);
        return list;
    }

}