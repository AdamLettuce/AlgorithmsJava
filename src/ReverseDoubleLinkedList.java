import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReverseDoubleLinkedList {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode reverseMyUglySolution(DoublyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        DoublyLinkedListNode a = head;
        DoublyLinkedListNode b = head.next;
        DoublyLinkedListNode c = null;
        a.next = c;//null

        c = b.next;
        b.next = a;
        a.prev = b;

        while (c != null) {
            a = b;
            b = c;
            c = b.next;
            b.next = a;
            a.prev = b;
        }

        head = b;
        return head;
    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode a = head;
        DoublyLinkedListNode tmp = null;

        while (a != null) {
            tmp = a.prev;
            a.prev = a.next;
            a.next = tmp;
            a = a.prev;
        }

        if (tmp != null) {
            head = tmp.prev;
        }

        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);
}