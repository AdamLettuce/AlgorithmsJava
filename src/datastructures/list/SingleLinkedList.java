package datastructures.list;

public class SingleLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;


    public void addBegin(T data) {
        addBegin(new Node<>(data));
    }

    void addBegin(Node<T> newNode) {
        incrementSize();
        if (isEmpty()) {
            first = newNode;
            last = newNode;
            return;
        }
        newNode.next = first;
        if (hasOneElement()) {
            last = first;
        }
        first = newNode;
    }

    public void addEnd(T data) {
        addEnd(new Node<>(data));
    }

    void addEnd(Node<T> newNode) {
        incrementSize();
        if (isEmpty()) {
            first = newNode;
            last = newNode;
            return;
        }
        last.next = newNode;
        if (hasOneElement()) {
            last = first;
        }
        last = newNode;
    }

    public T removeBegin() {
        if (isEmpty()) {
            return null;
        }
        T result = first.data;
        decrementSize();
        if (hasOneElement()) {
            first = null;
            last = null;
            return result;
        }
        first = first.next;
        return result;
    }

    T removeEnd() {
        if (isEmpty()) {
            return null;
        }
        decrementSize();
        if (hasOneElement()) {
            T result = first.data;
            first = null;
            last = null;
            return result;
        }
        Node<T> iterator = first;
        while (iterator.next != last) {
            iterator = iterator.next;
        }
        T result = last.data;
        iterator.next = null;
        last = iterator;
        return result;
    }

    private void decrementSize() {
        --size;
    }

    boolean hasOneElement() {
        return !isEmpty() && first == last;
    }

    private void incrementSize() {
        ++size;
    }

    boolean isEmpty() {
        return first == null && last == null;
    }

    int size() {
        return size;
    }

    @Override
    public String toString() {
        Node<T> iterator = first;
        StringBuilder sb = new StringBuilder();
        while (iterator != null) {
            sb.append(iterator.data);
            if (iterator.next != null) {
                sb.append(", ");
            }
            iterator = iterator.next;
        }
        return sb.toString();
    }

    T get(int i) {
        Node<T> iterator = first;
        for (int j = 0; j < i; j++) {
            iterator = iterator.next;
        }
        return iterator.data;
    }

    SingleLinkedList<T> reverseImmutable() {
        SingleLinkedList<T> newList = new SingleLinkedList<>();
        Node<T> iterator = first;
        while (iterator != null) {
            newList.addBegin(iterator.data);
            iterator = iterator.next;
        }
        return newList;
    }

    void reverseMutable() {
        if (isEmpty()) {
            return;
        }

        Node<T> a = first;
        Node<T> b = first.next;
        Node<T> c;

        a.next = null;

        while(b!=null) {
            c = b.next;
            b.next = a;
            a=b;
            b=c;
        }
        first = a;
    }

    public boolean hasCycle() {
        if(first == null) {
            return false;
        }
        Node<T> s = first;
        Node<T> f = first;
        while(f!=null && f.next!=null) {
            s=s.next;
            f=f.next.next;
            if(s==f) {
                return true;
            }
        }
        return false;
    }

}