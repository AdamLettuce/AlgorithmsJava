package datastructures.hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {

    @Test
    public void putNothingGetNull() {
        HashTable instance = new HashTable();
        assertNull(instance.get(null));
    }

    @Test
    public void putNullNullGetNull() {
        HashTable instance = new HashTable();
        instance.put(null,null);
        assertNull(instance.get(null));
    }

    @Test
    public void putNullOneGetOne() {
        HashTable instance = new HashTable();
        instance.put(null,"1");
        assertEquals("1",instance.get(null));
    }

    @Test
    public void putOneOneGetOne() {
        HashTable instance = new HashTable();
        instance.put(1,"1");
        assertEquals("1",instance.get(1));
    }

    @Test
    public void testCollision_putOneOne_putNineNine_getNine() {
        HashTable instance = new HashTable();
        instance.put(1,"1");
        instance.put(9,"9");
        assertEquals("1",instance.get(1));
        assertEquals("9",instance.get(9));
    }

    @Test
    public void testCollision_putOneOne_putOneNine_getNine() {
        HashTable instance = new HashTable();
        instance.put(1,"1");
        instance.put(1,"9");
        assertEquals("9",instance.get(1));
    }

    @Test
    public void testRemove_putOneOne() {
        HashTable instance = new HashTable();
        instance.put(1,"1");
        instance.remove(1);
        assertNull(instance.get(1));

    }
}