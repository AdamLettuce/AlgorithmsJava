package datastructures.queue;

import java.util.Arrays;

public class ArrayPriorityQueue {

    private Integer[] data = new Integer[8];
    private int count = 0;

    public static void main(String[] args) {
        ArrayPriorityQueue arrayPriorityQueue = new ArrayPriorityQueue();
        for (int i = 9; i > 0 ; i--) {
            arrayPriorityQueue.enqueue(i);
        }
        arrayPriorityQueue.enqueue(17);
        arrayPriorityQueue.enqueue(-1);
        System.out.println(arrayPriorityQueue);
    }

    public boolean enqueue(Integer item) {
        if(item==null) {
            return false;
        }
        if(count==0) {
            data[0] = item;
            ++count;
            return true;
        }

        if(count==data.length) {
            Integer[] newData = new Integer[count*2];
            for (int i=0;i<count;++i) {
                newData[i] = data[i];
            }
            data = newData;
        }

        int i = count - 1;
        while(i>=0 && data[i]>item) {
            data[i+1] = data[i];
            --i;
        }
        data[i+1] = item;
        ++count;
        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
