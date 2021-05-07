package datastructures.hashtable;

import decisiontable.Table;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class HashTable {

    public static final int SIZE = 8;

    private static class Entry {
        private Integer key;
        private String value;

        public Entry(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] table = new LinkedList[SIZE];

    public void put(Integer key, String value) {
        Integer index = hashCode(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry entry : table[index]) {
            if (Objects.equals(entry.key, key)) {
                entry.value = value;
                return;
            }
        }
        table[index].addLast(new Entry(key, value));
    }

    public String get(Integer key) {
        Integer index = hashCode(key);
        if (table[index] != null) {
            for (Entry entry : table[index]) {
                if (Objects.equals(entry.key, key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    private Entry getEntry(Integer key) {
        Integer index = hashCode(key);
        if (table[index] != null) {
            for (Entry entry : table[index]) {
                if (Objects.equals(entry.key, key)) {
                    return entry;
                }
            }
        }
        return null;
    }

    public void remove(Integer key) {
        Integer index = hashCode(key);
        if (table[index] != null) {
            for (Entry entry : table[index]) {
                if (Objects.equals(entry.key, key)) {
                    table[index].remove(entry);
                    return;
                }
            }
        }
    }

    private Integer hashCode(Integer key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key) % SIZE;
    }


}
