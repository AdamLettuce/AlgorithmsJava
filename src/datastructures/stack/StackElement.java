package datastructures.stack;

public class StackElement {
    int data;
    StackElement next;

    StackElement(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "" + data;
    }

}
