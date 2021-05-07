package datastructures.stack;

public class TwoStacksInOneArray {
    private Integer[] data;

    private int firstStackCount = 0;
    private int secondStackCount = 0;
    private int secondStackFirstIndex = 1;

    public TwoStacksInOneArray(int size) {
        if(size<=1) {
            throw new IllegalArgumentException("Minimum size for two stacks is 2.");
        }
        this.data = new Integer[size];
    }

    public void pushFirst(Integer element) {
        if(bothStacksAreFull()) {
            throw new IllegalArgumentException("Stack is full");
        }

        if(isFullFirst() && !isFullSecond()) {
            for (int i = secondStackFirstIndex; i < data.length-secondStackCount-secondStackFirstIndex; i++) {
                data[i+1] = data[i];
            }
            secondStackFirstIndex++;
        }

        data[firstStackCount++] = element;
    }

    private boolean bothStacksAreFull() {
        return isFullFirst() && isFullSecond();
    }

    public void pushSecond(Integer element) {
        if(bothStacksAreFull()) {
            throw new IllegalArgumentException("Stack is full");
        }

        if(!isFullFirst() && isFullSecond()) {
            for (int i = data.length-secondStackFirstIndex; i >= secondStackFirstIndex; i--) {
                data[i-1] = data[i];
            }
            secondStackFirstIndex--;
        }

        data[secondStackFirstIndex+secondStackCount++] = element;
    }

    public Integer popFirst() {
        if(isEmptyFirst()) {
            return null;
        }
        return data[--firstStackCount];
    }

    public Integer popSecond() {
        if(isEmptySecond()) {
            return null;
        }
        return data[secondStackFirstIndex + --secondStackCount];
    }

    public boolean isEmptyFirst() {
        return firstStackCount == 0;
    }

    public boolean isEmptySecond() {
        return secondStackCount == 0;
    }

    public boolean isFullFirst() {
        return firstStackCount == secondStackFirstIndex;
    }

    public boolean isFullSecond() {
        return secondStackFirstIndex + secondStackCount >= data.length;
    }
}
