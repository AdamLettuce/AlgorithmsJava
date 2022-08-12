package datastructures.list.signlelinked;

import org.junit.Test;

import static org.junit.Assert.*;

public class SLLTest {

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
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2();
        assertEquals(1, sll.getValueAt(0));
        assertEquals(2, sll.getValueAt(1));
    }

    @Test
    public void deleteBegin_oneElement() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1();
        assertEquals(sll.deleteBegin(),1);
        assertTrue(sll.isEmpty());
    }

    @Test
    public void deleteBegin_twoElements() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2();
        assertEquals(sll.deleteBegin(),1);
        assertEquals(sll.deleteBegin(),2);
        assertTrue(sll.isEmpty());
    }

    @Test
    public void deleteAtWithExceptions_beforeList() {
        assertWithException(-1);
    }

    @Test
    public void deleteAtWithExceptions_first() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3();
        assertEquals(sll.deleteAtWithExceptions(0),1);
    }

    @Test
    public void deleteAtWithExceptions_second() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3();
        assertEquals(sll.deleteAtWithExceptions(1),2);
    }

    @Test
    public void deleteAtWithExceptions_third() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3();
        assertEquals(3, sll.deleteAtWithExceptions(2));
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
        SingleLinkedListSimpleAdvancedMethods2 sll = newInstance();
        assertFalse(sll.containsRecursive(0));
    }

    @Test
    public void containsRecursive_0_false() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3();
        assertFalse(sll.containsRecursive(0));
    }

    @Test
    public void containsRecursive_1_true() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3();
        assertTrue(sll.containsRecursive(1));
    }

    @Test
    public void containsRecursive_2_true() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3();
        assertTrue(sll.containsRecursive(2));
    }

    @Test
    public void containsRecursive_3_true() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3();
        assertTrue(sll.containsRecursive(3));
    }

    @Test
    public void containsIterative_emptyList_0_false() {
        SingleLinkedListSimpleAdvancedMethods2 sll = newInstance();
        assertFalse(sll.containsIterative(0));
    }

    @Test
    public void containsIterative_0_false() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3();
        assertFalse(sll.containsIterative(0));
    }

    @Test
    public void containsIterative_1_true() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3();
        assertTrue(sll.containsIterative(1));
    }

    @Test
    public void containsIterative_2_true() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3();
        assertTrue(sll.containsIterative(2));
    }

    @Test
    public void containsIterative_3_true() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3();
        assertTrue(sll.containsIterative(3));
    }

    @Test
    public void testToString_emptyList() {
        SingleLinkedListSimpleAdvancedMethods2 sll = newInstance();
        assertEquals("()",sll.toString());
    }

    @Test
    public void testToString_listWith_1() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1();
        assertEquals("(1)",sll.toString());
    }

    @Test
    public void testToString_listWith_1_2() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2();
        assertEquals("(1,2)",sll.toString());
    }

    @Test
    public void getValueAt_emptyList() {
        SingleLinkedListSimpleAdvancedMethods2 sll = newInstance();
        try {
            sll.getValueAt(0);
        } catch (Exception e) {
            assertTrue(true);
            return;
        }
        fail();
    }

    @Test
    public void getValueAt_listWith_1_beforeList() {
        assertEquals(listWith_1().getValueAt(-1),1);
    }

    @Test
    public void getValueAt_listWith_1_onList() {
        assertEquals(listWith_1().getValueAt(0), 1);
    }

    @Test
    public void getValueAt_listWith_1_afterList() {
        assertEquals(listWith_1().getValueAt(1), 1);
    }

    @Test
    public void getValueAt_listWith_1_2_get0() {
        assertEquals(listWith_1_2().getValueAt(0), 1);
    }

    @Test
    public void getValueAt_listWith_1_2_get1() {
        assertEquals(listWith_1_2().getValueAt(1), 2);
    }

    @Test
    public void getNodeAt_emptyList() {
        SingleLinkedListSimpleAdvancedMethods2 sll = newInstance();
        try {
            sll.getNodeAt(0);
        } catch (Exception e) {
            assertTrue(true);
            return;
        }
        fail();
    }

    @Test
    public void getNodeAt_listWith_1_beforeList() {
        assertEquals(listWith_1().getNodeAt(-1).getValue(),1);
    }

    @Test
    public void getNodeAt_listWith_1_onList() {
        assertEquals(listWith_1().getNodeAt(0).getValue(), 1);
    }

    @Test
    public void getNodeAt_listWith_1_afterList() {
        assertEquals(listWith_1().getNodeAt(1).getValue(), 1);
    }

    @Test
    public void getNodeAt_listWith_1_2_get0() {
        assertEquals(listWith_1_2().getNodeAt(0).getValue(), 1);
    }

    @Test
    public void getNodeAt_listWith_1_2_get1() {
        assertEquals(listWith_1_2().getNodeAt(1).getValue(), 2);
    }

    @Test
    public void insertAfter_nullNode_throwsException() {
        SingleLinkedListSimpleAdvancedMethods2 sll = new SingleLinkedListSimpleAdvancedMethods2();
        try {
            sll.insertAfter(null, 1);
        } catch(Exception e) {
            assertTrue(true);
            return;
        }
        fail();
    }

    @Test
    public void insertAfter_listWithOneNode() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1();
        sll.insertAfter(sll.getNodeAt(0), 2);
        assertEquals(2,sll.getValueAt(1));
    }

    @Test
    public void insertAfter_listWithTwoNodes() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2();
        sll.insertAfter(sll.getNodeAt(0), 3);
        assertEquals(3,sll.getValueAt(1));
    }

    @Test
    public void insertAt_minus1() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3();
        sll.insertAt(4,-1);
        assertEquals(sll.size(),4);
        assertEquals(sll.getValueAt(0),4);
    }

    @Test
    public void insertAt_0() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3();
        sll.insertAt(4,0);
        assertEquals(sll.size(),4);
        assertEquals(sll.getValueAt(0),4);
    }

    @Test
    public void insertAt_1() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3();
        sll.insertAt(4,1);
        assertEquals(sll.size(),4);
        assertEquals(sll.getValueAt(1),4);
    }

    @Test
    public void insertAt_2() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3();
        sll.insertAt(4,2);
        assertEquals(sll.size(),4);
        assertEquals(sll.getValueAt(2),4);
    }

    @Test
    public void insertAt_3() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3();
        sll.insertAt(4,3);
        assertEquals(sll.size(),4);
        assertEquals(sll.getValueAt(3),4);
    }

    @Test
    public void insertEnd() {

        SingleLinkedListSimpleAdvancedMethods2 sll = newInstance();
        sll.insertEnd(1);
        sll.insertEnd(2);
        assertEquals(sll.getValueAt(0),1);
        assertEquals(sll.getValueAt(1),2);
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
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2();
        sll.reverse();
        assertEquals(2,sll.getValueAt(0));
        assertEquals(1,sll.getValueAt(1));
    }

    @Test
    public void reverse_listWithThreElements() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3();
        sll.reverse();
        assertEquals(3,sll.getValueAt(0));
        assertEquals(2,sll.getValueAt(1));
        assertEquals(1,sll.getValueAt(2));
    }

    @Test
    public void reverse_listWithFourElements() {
        SingleLinkedListSimpleAdvancedMethods2 sll = listWith_1_2_3_4();
        sll.reverse();
        assertEquals(4,sll.getValueAt(0));
        assertEquals(3,sll.getValueAt(1));
        assertEquals(2,sll.getValueAt(2));
        assertEquals(1,sll.getValueAt(3));
    }

    private SingleLinkedListSimpleAdvancedMethods2 newInstance() {
        return new SingleLinkedListSimpleAdvancedMethods2();
    }

    private SingleLinkedListSimpleAdvancedMethods2 listWith_1() {
        SingleLinkedListSimpleAdvancedMethods2 sll = newInstance();
        sll.insertBegin(1);
        return sll;
    }

    private SingleLinkedListSimpleAdvancedMethods2 listWith_1_2() {
        SingleLinkedListSimpleAdvancedMethods2 sll = newInstance();
        sll.insertBegin(2);
        sll.insertBegin(1);
        return sll;
    }

    private SingleLinkedListSimpleAdvancedMethods2 listWith_1_2_3() {
        SingleLinkedListSimpleAdvancedMethods2 sll = newInstance();
        sll.insertBegin(3);
        sll.insertBegin(2);
        sll.insertBegin(1);
        return sll;
    }

    private SingleLinkedListSimpleAdvancedMethods2 listWith_1_2_3_4() {
        SingleLinkedListSimpleAdvancedMethods2 sll = newInstance();
        sll.insertBegin(4);
        sll.insertBegin(3);
        sll.insertBegin(2);
        sll.insertBegin(1);
        return sll;
    }

}