package datastructures.tries;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieWithMapWithHashMapTest {

    @Test
    public void insert_null() {
        TrieWithHashMap trie = new TrieWithHashMap();
        trie.insert(null);
        assertFalse(trie.contains(null));
    }

    @Test
    public void insert_empty() {
        TrieWithHashMap trie = new TrieWithHashMap();
        trie.insert("");
        assertFalse(trie.contains(""));
    }

    @Test
    public void insert_blank() {
        TrieWithHashMap trie = new TrieWithHashMap();
        trie.insert(" ");
        assertFalse(trie.contains(" "));
    }

    @Test
    public void remove_word_from_empty() {
        TrieWithHashMap trie = new TrieWithHashMap();
        trie.remove("a");
        assertFalse(trie.contains("a"));
    }

    @Test
    public void remove_single_word_from_containing_this_word() {
        TrieWithHashMap trie = new TrieWithHashMap();
        trie.insert("a");
        trie.remove("a");
        assertFalse(trie.contains("a"));
    }

    @Test
    public void remove_single_threeletter_word_from_containing_this_word() {
        TrieWithHashMap trie = new TrieWithHashMap();
        trie.insert("abc");
        trie.remove("abc");
        assertFalse(trie.contains("abc"));
    }

    @Test
    public void remove_one_threeletter_and_one_four_letter_word_remove_shorter() {
        TrieWithHashMap trie = new TrieWithHashMap();
        trie.insert("abc");
        trie.insert("abcd");

        trie.remove("abc");

        assertFalse(trie.contains("abc"));
        assertTrue(trie.contains("abcd"));
    }

    @Test
    public void remove_one_threeletter_and_one_four_letter_word_remove_longer() {
        TrieWithHashMap trie = new TrieWithHashMap();
        trie.insert("abc");
        trie.insert("abcd");

        trie.remove("abcd");

        assertFalse(trie.contains("abcd"));
        assertTrue(trie.contains("abc"));
    }

    @Test
    public void remove_two_threeletter_words_common_ancestor_remove_one() {
        TrieWithHashMap trie = new TrieWithHashMap();
        trie.insert("abc");
        trie.insert("abd");

        trie.remove("abc");

        assertFalse(trie.contains("abc"));
        assertTrue(trie.contains("abd"));
    }

    @Test
    public void longestCommonPrefix_card_care_car() {
        TrieWithHashMap trie = new TrieWithHashMap();
        String result = trie.longestCommonPrefiX("card","care");
        assertEquals("car",result);
    }

    @Test
    public void longestCommonPrefix_car_care_car() {
        TrieWithHashMap trie = new TrieWithHashMap();
        String result = trie.longestCommonPrefiX("car","care");
        assertEquals("car",result);
    }

    @Test
    public void longestCommonPrefix_car_dog_empty() {
        TrieWithHashMap trie = new TrieWithHashMap();
        String result = trie.longestCommonPrefiX("car","dog");
        assertEquals("",result);
    }

    @Test
    public void longestCommonPrefix_car_empty_empty() {
        TrieWithHashMap trie = new TrieWithHashMap();
        String result = trie.longestCommonPrefiX("car","");
        assertEquals("car",result);
    }
}