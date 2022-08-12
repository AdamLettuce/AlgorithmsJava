package datastructures.list.doublelinked;

public class DoubleLinkedListSimple implements DoubleLinkedList<Integer> {

    private static final class Node<T> {
        private Node<T> next;
        private Node<T> prev;
        private T value;

        public Node(T value) {
            this.value = value;
        }
    }

    Node<Integer> head;
    Node<Integer> tail;

    @Override
    public void addBegin(Integer data) {
        Node<Integer> newNode = new Node<>(data);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;

            head = newNode;
        }
    }

    @Override
    public void addEnd(Integer data) {
        Node<Integer> newNode = new Node<>(data);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;

            tail = newNode;
        }
    }

    @Override
    public Integer removeBegin() {
        if(isEmpty()) {
            System.out.println("Cannot remove from empty list.");
            return -1;
        }

        Node<Integer> toRemove = head;
        Integer result = toRemove.value;
        if(head == tail) {
            head = null;
            tail = null;
        } else {
            head.next.prev = null;
            head = head.next;
            toRemove.next = null;
        }

        return result;
    }

    @Override
    public Integer removeEnd() {
        if(isEmpty()) {
            System.out.println("Cannot remove from empty list.");
            return -1;
        }

        Node<Integer> toRemove = tail;
        Integer result = toRemove.value;
        if(head == tail) {
            head = null;
            tail = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
            toRemove.prev = null;
        }

        return result;
    }

    @Override
    public boolean isEmpty() {
        return head==tail && head==null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Integer get(int i) {
        return null;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        Node<Integer> iterator = head;
        while (iterator.next!=null) {
            stringBuilder.append(iterator.value).append(", ");
            iterator = iterator.next;
        }
        stringBuilder.append(iterator.value);

        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        DoubleLinkedListSimple list = new DoubleLinkedListSimple();
        list.addBegin(1);
        list.addEnd(2);
        list.addEnd(3);
        list.addBegin(0);

        System.out.println(list);

//        System.out.println(list.removeBegin());
//        System.out.println(list.removeBegin());
//        System.out.println(list.removeBegin());
//        System.out.println(list.removeBegin());
//        System.out.println(list.removeBegin());

//        System.out.println(list.removeEnd());
//        System.out.println(list.removeEnd());
//        System.out.println(list.removeEnd());
//        System.out.println(list.removeEnd());
//        System.out.println(list.removeEnd());
//        System.out.println(list.removeEnd());

        System.out.println(list.removeBegin());
        System.out.println(list.removeEnd());
        System.out.println(list.removeBegin());
        System.out.println(list.removeEnd());
        System.out.println(list.removeBegin());
        System.out.println(list.removeEnd());

        list.addEnd(124);
        list.addEnd(125);
        list.addBegin(122);
        list.addBegin(121);
        System.out.println(list);

    }
}
