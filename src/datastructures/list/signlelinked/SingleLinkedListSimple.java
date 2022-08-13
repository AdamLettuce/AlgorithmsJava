package datastructures.list.signlelinked;

public class SingleLinkedListSimple implements SignleLinkedList<Integer> {

    private static final class Node<T> {
        Node<T> next;
        T value;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<Integer> head;

    @Override
    public void addBegin(Integer data) {
        Node<Integer> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    @Override
    public Integer removeBegin() {
        if (isEmpty()) {
            System.out.println("Cannot remove from empty list.");
            return -1;
        }

        int result = head.value;
        Node<Integer> tmp = head.next;
        if (tmp == null) {
            head = null;
            return result;
        }

        head.next = null;
        head = tmp;

        return result;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int result = 0;
        Node<Integer> iterator = head;
        while (iterator != null) {
            ++result;
            iterator = iterator.next;
        }
        return result;
    }

    @Override
    public Integer get(int i) {
        if(i<0 || isEmpty()) {
            return -1;
        }

        Node<Integer> iterator = head;
        int idx = 0;
        while (iterator != null && idx < i) {
            iterator = iterator.next;
            ++idx;
        }

        return iterator != null ? iterator.value : -1;
    }

    @Override
    public String toString() {

        if(isEmpty()) {
            return ("[]");
        }

        StringBuilder stringBuilder = new StringBuilder();

        Node<Integer> iterator = head;
        stringBuilder.append("[");
        while (iterator.next != null) {
            stringBuilder.append(iterator.value).append(", ");
            iterator = iterator.next;
        }
        stringBuilder.append(iterator.value).append("]");

        return stringBuilder.toString();
    }

    @Override
    public void addAt(int position, int value) {
        if (position <= 0 || isEmpty()) {
            addBegin(value);
        } else {
            int i = 0;
            Node<Integer> it = head;
            Node<Integer> newNode = new Node<>(value);
            
            while (i < position - 1 && it.next != null) {
                it = it.next;
                ++i;
            }

            newNode.next = it.next;
            it.next = newNode;
        }

    }

    public static void main(String[] args) {
        SingleLinkedListSimple l = new SingleLinkedListSimple();
        l.addBegin(1);
        l.addBegin(2);
        l.addBegin(3);
        System.out.println(l);

        System.out.println("Removed from begin: " + l.removeBegin());
        l.addBegin(4);
        System.out.println(l);
        System.out.println("Size = " + l.size());

        l.addAt(2,91);
        System.out.println(l);

        System.out.println(l.removeBegin());
        System.out.println(l.removeBegin());
        System.out.println(l.removeBegin());
        System.out.println(l.removeBegin());
        System.out.println(l.removeBegin());
    }
}
