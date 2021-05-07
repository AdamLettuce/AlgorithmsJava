package datastructures.queue;

public class StackWithMinimum {
    private static final int MAX_SIZE = 8;
    private Integer[] data = new Integer[MAX_SIZE];
    private int elementsCount = 0;
    private int min = 0;

    public boolean push(Integer item) {
        if(elementsCount ==0) {
            min = item;
            data[elementsCount++] = 0;
            return true;
        }
        if(elementsCount>0 && elementsCount<MAX_SIZE) {
            if(item<min) {
                data[elementsCount++] = min - item;
                min = item;
            } else {
                data[elementsCount++] = item;
            }
            return true;
        }
        return false;
    }

    public Integer pop() {
        if(elementsCount>0) {
            if(data[elementsCount-1]>min) {
                return data[--elementsCount];
            } else {
                int oldMin = min;
                min = data[--elementsCount] + min;
                return oldMin;
            }
        }
        return null;
    }

    public Integer min() {
        return min;
    }
}
