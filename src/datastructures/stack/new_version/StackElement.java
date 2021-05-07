package datastructures.stack.new_version;

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
