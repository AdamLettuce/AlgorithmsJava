package datastructures.list.signlelinked;

public class SingleLinkedListSimpleAdvancedMethods {
    private static final class Node {
        private Node next;
        private final int data;

        public Node(int data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;

    public static void main(String[] args) {
        SingleLinkedListSimpleAdvancedMethods listSingleLinked = new SingleLinkedListSimpleAdvancedMethods();
        System.out.println(listSingleLinked);
        listSingleLinked.insertBegin(5);
        listSingleLinked.insertBegin(15);
        listSingleLinked.insertEnd(4);
        listSingleLinked.insertEnd(3);

        listSingleLinked.insertBefore(8, 10);
        System.out.println(listSingleLinked);


        System.out.println(listSingleLinked.deleteAtWithExceptions(5));
        System.out.println(listSingleLinked);

    }

    void insertBegin(int data) {
        Node n = new Node(data);
        if (head != null) {
            n.next = head;
        }
        head = n;
    }

    int deleteBegin() {
        valiadte(isEmpty(), "Cannot remove from empty list");
        int result = head.data;
        Node tmp = head;
        head = head.next;
        tmp.next = null;
        return result;
    }

    public boolean isEmpty() {
        return head == null;
    }

    int deleteAtWithExceptions(int index) {
        valiadte(isEmpty(), "Cannot remove from empty list");
        valiadte(index < 0, "Cannot remove from before list");
        if (index == 0) {
            return deleteBegin();
        }
        int i = 0;
        Node previous = head;
        while (i < index - 1 && previous.next != null) {
            ++i;
            previous = previous.next;
        }
        boolean removingNodeAfterLast = previous.next == null;
        if (!removingNodeAfterLast) {
            Node toRemove = previous.next;
            previous.next = toRemove.next;
            toRemove.next = null;
            return toRemove.data;
        }
        throw new IllegalArgumentException("Cannot remove after list");
    }

    boolean containsRecursive(int data) {
        return containsRecursive(data, head);
    }

    boolean containsRecursive(int data, Node node) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        }
        return containsRecursive(data, node.next);
    }

    boolean containsIterative(int data) {
        Node iterator = head;
        while (iterator != null) {
            if (iterator.data == data) {
                return true;
            }
            iterator = iterator.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node iterator = head;
        while (iterator != null) {
            sb.append(iterator.data).append(" ");
            iterator = iterator.next;
        }
        return sb.toString();
    }

    int getAt(int index) {
        valiadte(isEmpty(), "Empty list");
        int i = 0;
        Node iterator = head;
        while (i < index && iterator.next != null) {
            ++i;
            iterator = iterator.next;
        }
        return iterator.data;
    }

    void insertBefore(int data, int index) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            return;
        }
        if (index <= 0) {
            insertBegin(data);
            return;
        }
        int i = 0;
        Node it = head;
        while (i < index - 1 && it.next != null) {
            it = it.next;
            ++i;
        }
        newNode.next = it.next;
        it.next = newNode;
    }

    void insertAt(int data, int index) {
        if (isEmpty() || index <= 0) {
            insertBegin(data);
            return;
        }
        Node newNode = new Node(data);
        Node prev = head;
        int i = 0;
        while (i < index - 1 && prev.next != null) {
            ++i;
            prev = prev.next;
        }

        newNode.next = prev.next;
        prev.next = newNode;

    }

    void insertAfter(Node node, int data) {
        if (node == null) {
            throw new IllegalArgumentException("Cannot insert after null node.");
        }
        Node newNode = new Node(data);
        newNode.next = node.next;
        node.next = newNode;
    }

    private void valiadte(boolean b, String s) {
        if (b) {
            throw new IllegalArgumentException(s);
        }
    }

    //less common methods
    //O(n)
    void insertEnd(int data) {
        Node n = new Node(data);
        if (isEmpty()) {
            head = n;
            return;
        }
        Node iterator = head;
        while (iterator.next != null) {
            iterator = iterator.next;
        }
        iterator.next = n;
    }

    //O(n)
    int size() {
        Node it = head;
        int result = 0;
        while (it != null) {
            ++result;
            it = it.next;
        }
        return result;
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }

        Node first = head;
        Node second = head.next;
        Node third;

        while (second != null) {
            third = second.next;
            second.next = first;
            first = second;
            second = third;
        }

        head = first;
    }
}
