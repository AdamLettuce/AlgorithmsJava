package datastructures.list.signlelinked;

public class SLL {

    public void reverse() {
        if(isEmpty()) {
            return;
        }

        Node first = head;
        Node second = head.next;
        Node third;

        while(second!=null) {
            third = second.next;
            second.next = first;
            first = second;
            second = third;
        }

        head = first;
    }

    static final class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node head;

    void insertBegin(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    int deleteBegin() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot delete from empty list");
        }
        Node toDelete = head;
        head = head.next;
        toDelete.next = null;
        return toDelete.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    int deleteAtWithExceptions(int index) {
        if(isEmpty()) {
            throw new IllegalArgumentException();
        }
        if(index<0 || index > size()) {
            throw new IllegalArgumentException();
        }
        if(index==0) {
            return deleteBegin();
        }

        Node prev = head;
        int i = 0;
        while(i<index-1 && prev.next!=null) {
            ++i;
            prev = prev.next;
        }

        Node toDelete = prev.next;
        prev.next = toDelete != null ? toDelete.next : null;
        toDelete.next = null;

        return toDelete.value;
    }

    boolean containsRecursive(int data) {
        return containsRecursive(data, head);
    }

    boolean containsRecursive(int data, Node n) {
        if(n==null) {
            return false;
        }
        if(n.value ==data) {
            return true;
        }
        return containsRecursive(data,n.next);
    }

    boolean containsIterative(int data) {
        Node it = head;
        while(it!=null) {
            if(it.value ==data) {
                return true;
            }
            it = it.next;
        }
        return false;
    }

    @Override
    public String toString() {
        if(isEmpty()) {
            return "()";
        }
        Node it = head;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        while(it.next!=null) {
            sb.append(it.value);
            sb.append(",");
            it=it.next;
        }
        sb.append(it.value);
        sb.append(")");
        return sb.toString();
    }

    int getValueAt(int index) {
        return getNodeAt(index).value;
    }

    Node getNodeAt(int index) {
        if(isEmpty()) {
            throw new IllegalArgumentException();
        }
        Node it = head;
        int i = 0;
        while(i<index && it.next != null) {
            ++i;
            it = it.next;
        }
        return it;
    }

    void insertAfter(Node node, int data) {
        if(node==null) {
            throw new IllegalArgumentException("Cannot insert after null node.");
        }
        Node newNode = new Node(data);
        newNode.next = node.next;
        node.next = newNode;
    }

    void insertAt(int data, int index) {
        if(isEmpty() || index <= 0) {
            insertBegin(data);
            return;
        }
        Node newNode = new Node(data);
        Node prev = head;
        int i = 0;
        while(i<index-1 && prev.next!=null) {
            ++i;
            prev = prev.next;
        }

        newNode.next = prev.next;
        prev.next = newNode;

    }

    //less common methods
    //O(n)
    void insertEnd(int data) {
        Node n = new Node(data);
        if(isEmpty()) {
            head = n;
            return;
        }
        Node it = head;
        while(it.next!=null) {
            it = it.next;
        }
        it.next=n;
    }

    //O(n)
    int size() {
        Node it = head;
        int result = 0;
        while(it!=null) {
            ++result;
            it=it.next;
        }
        return result;
    }

}