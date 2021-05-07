package datastructures;

import java.util.Arrays;

public class Heap {
    public static final int max_size = 32;
    int[] data = new int[max_size];
    int elementsCount = 0;

    public void insert(int value) {
        if(isFull()) {
            throw new IllegalArgumentException("Cannot insert to full heap");
        }
        data[elementsCount++] = value;
        bubbleUp();
    }

    private boolean isFull() {
        return elementsCount == data.length;
    }

    private void bubbleUp() {
        int index = elementsCount - 1;
        while (index > 0 && data[parentIndex(index)] < data[index]) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index, int parentIndex) {
        int tmp = data[parentIndex];
        data[parentIndex] = data[index];
        data[index] = tmp;
    }

    public int remove() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot remove from empty heap");
        }

        int result = data[0];
        data[0] = data[--elementsCount];
        data[elementsCount] = 0;

        bubbleDown();
        return result;
    }

    private void bubbleDown() {
        int i = 0;
        while(i< elementsCount && !isValidParent(i)) {
            i = swap(i);
        }
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < elementsCount;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < elementsCount;
    }

    private boolean isEmpty() {
        return elementsCount ==0;
    }

    private boolean isValidParent(int i) {
        if(!hasLeftChild(i)) {
            return true;
        }
        boolean isValid = data[i] >= leftChild(i);
        if(hasRightChild(i)) {
            isValid &= data[i] >= rightChild(i);
        }
        return isValid;
    }

    private int rightChild(int i) {
        return data[rightChildIndex(i)];
    }

    private int leftChild(int i) {
        return data[leftChildIndex(i)];
    }

    private int rightChildIndex(int i) {
        return (i*2)+2;
    }

    private int leftChildIndex(int i) {
        return (i*2)+1;
    }

    private int swap(int i) {
        int indexToSwapWith = findIndexToSwap(i);
        swap(indexToSwapWith, i);
        return indexToSwapWith;
    }

    private int findIndexToSwap(int i) {
        if(!hasLeftChild(i)) {
            return i;
        }
        if(!hasRightChild(i)) {
            return leftChildIndex(i);
        }
        return leftChild(i) > rightChild(i) ? leftChildIndex(i) : rightChildIndex(i);
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(15);
        heap.insert(10);
        heap.insert(3);
        heap.insert(8);
        heap.insert(12);
        heap.insert(9);
        heap.insert(4);
        heap.insert(1);
        heap.insert(24);

        System.out.println(Arrays.toString(heap.data));
        System.out.println(heap.remove());
        System.out.println(Arrays.toString(heap.data));
        System.out.println("Heap sort");
        while(!heap.isEmpty()) {
            System.out.println(heap.remove());
        }
    }
}
