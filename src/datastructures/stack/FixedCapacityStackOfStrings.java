package datastructures.stack;

class FixedCapacityStackOfStrings {

    private String[] data;
    private int count = 0;

    FixedCapacityStackOfStrings(int capacity) {
        this.data = new String[capacity];
    }

    boolean isEmpty() {
        return count == 0;
    }

    int size() {
        return count;
    }

    boolean push(String s) {
        if (count + 1 <= data.length) {
            data[count++] = s;
            return true;
        }
        return false;
    }

    String pop() {
        return isEmpty() ? null : data[--count];
    }
}
