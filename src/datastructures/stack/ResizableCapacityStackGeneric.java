package datastructures.stack;

class ResizableCapacityStackGeneric<T> {

    private T[] data;
    private int count = 0;



    ResizableCapacityStackGeneric(int size) {
        data = (T[])new Object[size];
    }

    void push(T element) {
        if(count==data.length) {
            resize(data.length*2);
        }
        data[count++] = element;
    }

    T pop() {
        if(count>0 && count==data.length/4) {
            resize((int)(data.length*0.25));
        }
        return isEmpty()?null:data[--count];
    }

    int size() {
        return count;
    }

    boolean isEmpty() {
        return count == 0;
    }

    private void resize(int newSize) {
        T[] newData = (T[]) new Object[newSize];
        for (int i = 0; i < count; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


































    /*
    ResizableCapacityStackGeneric(int capacity) {
        this.data = (T[]) new Object[capacity];
    }

    boolean isEmpty() {
        return count == 0;
    }

    int size() {
        return count;
    }

    void push(T s) {
        if(count==data.length) {
            resize(2);
        }
        data[count++] = s;
    }

    T pop() {
        T item = data[--count];
        if(count>0 && count==data.length/4) {
            resize(0.5);
        }
        return item;
    }

    int maxSize() {
        return data.length;
    }

    private void resize(double multiplier) {
        int l = (int) (data.length * multiplier);
        T[] newData = (T[])new Object[l];
        for (int i = 0; i < count; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
*/
}
