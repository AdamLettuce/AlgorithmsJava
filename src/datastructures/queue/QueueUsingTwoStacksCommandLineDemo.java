package datastructures.queue;


import java.util.Scanner;

import static datastructures.queue.OperationType.DEQUEUE;
import static datastructures.queue.OperationType.ENQUEUE;
import static datastructures.queue.OperationType.PRINT;

public class QueueUsingTwoStacksCommandLineDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linesCount = Integer.parseInt(scanner.nextLine());
        MyQueue queue = new StackQueue(linesCount);
        for (int lineCount = 0; lineCount < linesCount; ++lineCount) {
            analyzeLine(scanner, queue);
        }
    }

    private static void analyzeLine(Scanner scanner, MyQueue queue) {
        String[] line = scanner.nextLine().split(" ");
        String operation = line[0];
        if (line.length == 1 && DEQUEUE.getCode().equals(operation)) {
            queue.deQueue();
        }
        if (line.length == 1 && PRINT.getCode().equals(operation)) {
            System.out.println(queue.peek());
        }
        if (line.length == 2 && ENQUEUE.getCode().equals(operation)) {
            queue.enQueue(Integer.parseInt(line[1]));
        }
    }

}

enum OperationType {
    ENQUEUE("1"),
    DEQUEUE("2"),
    PRINT("3");

    private final String code;

    OperationType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}