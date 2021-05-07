package datastructures.stack;

public class StackUsingArray<E> {
    public static void main(String[] args) {
        StackUsingArray<String> stack = new StackUsingArray<>(3);
        stack.push("a");
        stack.print();
        stack.push("b");
        stack.print();
        stack.push("c");
        stack.push("d");
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        stack.print();
    }

    private int capacity;
    private E[] elements;
    private int count;

    private StackUsingArray(int capacity) {
        this.capacity = capacity;
        this.elements = (E[])new Object[capacity];
    }

    private void print() {
        for (int i = count-1; i >= 0; i--) {
            System.out.println(elements[i]);
        }
        System.out.println("----");
    }

    private E pop() {
        if(count>0) {
            return elements[--count];
        }
        return null;
    }

    private void push(E element) {
        if(count<capacity) {
            elements[count++] = element;
        }
    }
}
