package datastructures.list;

public class Node<V> {

    V data;
    Node<V> next;

    Node(V data) {
        this.data = data;
    }

    public Node<V> getNext() {
        return next;
    }
}