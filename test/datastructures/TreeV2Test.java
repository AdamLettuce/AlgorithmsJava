package datastructures;

import datastructures.trees.Tree_v2;
import datastructures.trees.Tree;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class TreeV2Test {

    @Test
    public void test_insert_() {
        Tree t = treeWithSevenElements();

        t.preorder();
        System.out.println();
        t.inorder();
        System.out.println();
        t.postorder();
    }

    private Tree treeWithSevenElements() {
        Tree t = new Tree();
        t.insert(7);
        t.insert(4);
        t.insert(9);
        t.insert(1);
        t.insert(6);
        t.insert(8);
        t.insert(10);
        return t;
    }

    @Test
    public void test_insert_differentTree() {
        Tree t = treeWithNineElements();

        assertTrue(t.find(5));
        assertTrue(t.find(10));
        assertTrue(t.find(15));
        assertFalse(t.find(9));
        assertFalse(t.find(11));
        assertFalse(t.find(7));
        assertFalse(t.find(4));
        assertFalse(t.find(14));
        assertTrue(t.find(17));
    }

    private Tree treeWithNineElements() {
        Tree t = new Tree();
        t.insert(10);
        t.insert(5);
        t.insert(15);
        t.insert(6);
        t.insert(1);
        t.insert(8);
        t.insert(12);
        t.insert(18);
        t.insert(17);
        return t;
    }

    @Test
    public void test_print_height_min() {

        Tree t = treeWith8Elements();

        t.preorder();
        System.out.println();
        t.inorder();
        System.out.println();
        t.postorder();
        System.out.println();
        System.out.println(t.height());
        System.out.println(t.min());

    }

    @Test
    public void test_isTheSame() {
        Tree t1 = new Tree();
        t1.insert(10);

        Tree t2 = new Tree();
        t2.insert(10);

        assertTrue(t1.areTheSame(t2));
    }

    @Test
    public void test_isTheSame_0() {
        Tree t1 = new Tree();
        t1.insert(10);
        t1.insert(5);

        Tree t2 = new Tree();
        t2.insert(10);
        t2.insert(5);

        assertTrue(t1.areTheSame(t2));
    }

    @Test
    public void test_isTheSame_00() {
        Tree t1 = new Tree();
        t1.insert(10);
        t1.insert(5);
        t1.insert(15);

        Tree t2 = new Tree();
        t2.insert(10);
        t2.insert(5);
        t2.insert(15);

        assertTrue(t1.areTheSame(t2));
    }

    @Test
    public void test_isTheSame_000() {
        Tree t1 = new Tree();
        t1.insert(10);
        t1.insert(5);
        t1.insert(15);

        Tree t2 = new Tree();
        t2.insert(10);
        t2.insert(5);
        t2.insert(14);

        assertFalse(t1.areTheSame(t2));
    }

    @Test
    public void test_isTheSame_1() {
        Tree t1 = treeWith8Elements();

        Tree t2 = new Tree();
        t2.insert(21);
        t2.insert(10);
        t2.insert(6);
        t2.insert(4);
        t2.insert(8);
        t2.insert(30);
        t2.insert(21);
        t2.insert(3);

        assertFalse(t1.areTheSame(t2));

    }

    @Test
    public void test_isTheSame_11() {
        Tree t1 = treeWith8Elements();

        Tree t2 = new Tree();
        t2.insert(20);
        t2.insert(10);
        t2.insert(6);
        t2.insert(4);
        t2.insert(8);
        t2.insert(30);
        t2.insert(221);
        t2.insert(3);

        assertFalse(t1.areTheSame(t2));

    }

    @Test
    public void test_isTheSame_10() {
        Tree t1 = treeWith8Elements();

        Tree t2 = treeWith8Elements();
//        t2.getLeftChildOfRootSetValue(50);
        System.out.println(t2.validate());
        assertTrue(t1.areTheSame(t2));

    }

    private Tree treeWith8Elements() {
        Tree t2 = new Tree();
        t2.insert(20);
        t2.insert(10);
        t2.insert(6);
        t2.insert(4);
        t2.insert(8);
        t2.insert(30);
        t2.insert(21);
        t2.insert(3);
        return t2;
    }

    @Test
    public void test_validate_true() {
        Tree t2 = treeWith8Elements();
        assertTrue(t2.validate());
    }

    @Test
    public void test_validate_false() {
        Tree t2 = treeWith8Elements();
        t2.swapRoot();
        assertFalse(t2.validate());
    }

    @Test
    public void test_validate_emptyTree_false() {
        Tree t2 = new Tree();
        assertTrue(t2.validate());
    }

    @Test
    public void test_validate_oneElement_true() {
        Tree t2 = new Tree();
        t2.insert(10);
        assertTrue(t2.validate());
    }

    @Test
    public void test_distanceFromRoot_zero() {
        Tree t2 = treeWith8Elements();

        assertEquals(Integer.valueOf(20),t2.getNodesAtDistance(0).get(0));

        assertEquals(Integer.valueOf(10),t2.getNodesAtDistance(1).get(0));
        assertEquals(Integer.valueOf(30),t2.getNodesAtDistance(1).get(1));

        assertEquals(Integer.valueOf(6),t2.getNodesAtDistance(2).get(0));
        assertEquals(Integer.valueOf(21),t2.getNodesAtDistance(2).get(1));

        assertEquals(Integer.valueOf(4),t2.getNodesAtDistance(3).get(0));
        assertEquals(Integer.valueOf(8),t2.getNodesAtDistance(3).get(1));

        assertEquals(Integer.valueOf(3),t2.getNodesAtDistance(4).get(0));

        assertEquals(Collections.emptyList(),t2.getNodesAtDistance(5));
    }

    @Test
    public void test_empty_sizeZero() {
        assertEquals(0,new Tree().size());
    }

    @Test
    public void test_oneElement_sizeOne() {
        Tree t = new Tree();
        t.insert(10);
        assertEquals(1,t.size());
    }

    @Test
    public void test_eightElements_sizeEight() {
        assertEquals(8,treeWith8Elements().size());
    }

    @Test
    public void test_empty_zeroLeaves() {
        assertEquals(0,new Tree().countLeaves());
    }

    @Test
    public void test_oneElement_oneLeave() {
        Tree t = new Tree();
        t.insert(10);
        assertEquals(1,t.countLeaves());
    }

    @Test
    public void test_twoElements_oneLeave() {
        Tree t = new Tree();
        t.insert(10);
        t.insert(5);
        assertEquals(1,t.countLeaves());
    }

    @Test
    public void test_twoElements_twoLeaves() {
        Tree t = new Tree();
        t.insert(10);
        t.insert(5);
        t.insert(15);
        assertEquals(2,t.countLeaves());
    }

    @Test
    public void test_fourElements_threeLeaves() {
        Tree t = new Tree();
        t.insert(10);
        t.insert(5);
        t.insert(15);
        t.insert(1);
        t.insert(9);
        assertEquals(3,t.countLeaves());
    }

    @Test
    public void test_areSibling_emptyTree() {
        Tree t = new Tree();
        assertFalse(t.areSibling(1,2));
    }

    @Test
    public void test_areSibling_oneElementInTree() {
        Tree t = new Tree();
        t.insert(10);
        assertFalse(t.areSibling(1,2));
    }

    @Test
    public void test_areSibling_threeElementsInTree_allInTree_true() {
        Tree t = new Tree();
        t.insert(10);
        t.insert(9);
        t.insert(11);
        assertTrue(t.areSibling(9,11));
    }

    @Test
    public void test_areSibling_threeElementsInTree_notAllInTree_false() {
        Tree t = new Tree();
        t.insert(10);
        t.insert(9);
        t.insert(11);
        assertFalse(t.areSibling(9,12));
    }

    @Test
    public void test_areSibling_fourElementsInTree_allInTreeDifferentRoots_false() {
        Tree t = new Tree();
        t.insert(20);
        t.insert(10);
        t.insert(30);
        t.insert(5);
        assertFalse(t.areSibling(5,30));
    }

    //ancestor tests
    @Test
    public void test_getAncestor_emptyTree() {
        Tree t = new Tree();
        assertNull(t.getAncestor(1));
    }

    @Test
    public void test_getAncestor_oneElementInTree() {
        Tree t = new Tree();
        t.insert(10);
        assertNull(t.getAncestor(10));
    }

    @Test
    public void test_getAncestor_threeElementsInTree_allInTree_true() {
        Tree t = new Tree();
        t.insert(10);
        t.insert(9);
        t.insert(11);
        assertEquals(Integer.valueOf(10),t.getAncestor(9));
        assertEquals(Integer.valueOf(10),t.getAncestor(11));
        assertNull(t.getAncestor(15));
    }

    @Test
    public void test_getAncestor_fourElementsInTree_allInTreeDifferentRoots_false() {
        Tree t = new Tree();
        t.insert(20);
        t.insert(10);
        t.insert(30);
        t.insert(5);
        assertEquals(Integer.valueOf(10),t.getAncestor(5));
    }

    @Test
    public void test_min__codewithmoshRecursiveVersion_wrong() {

        Tree_v2 t = new Tree_v2();
        t.insert(20);
        t.insert(10);
        t.insert(6);
        t.insert(4);
        t.insert(8);
        t.insert(30);
        t.insert(21);
        t.insert(3);

//        System.out.println(t.min());

    }
}