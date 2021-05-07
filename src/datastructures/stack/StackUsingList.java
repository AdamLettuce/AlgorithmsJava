package datastructures.stack;

public class StackUsingList<E> {
    public static void main(String[] args) {
        StackUsingList<String> stack = new StackUsingList<>();
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
        System.out.println(stack.pop());
        stack.print();
    }


    private int count;
    private Node head;

    private class Node {
        E item;
        Node next;
    }

    private StackUsingList() {
    }

    private void print() {
        Node iterator = head;
        while(iterator!=null) {
            System.out.println(iterator.item);
            iterator = iterator.next;
        }
        System.out.println("----");
    }

    private E pop() {
        Node oldHead = head;
        if(oldHead!=null) {
            head = head.next;
            return oldHead.item;
        }
        return null;
    }

    private void push(E element) {
        Node newNode = new Node();
        newNode.item = element;
        newNode.next = head;
        head = newNode;
    }
}
