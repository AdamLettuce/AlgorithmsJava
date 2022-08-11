package datastructures.stack;


public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        QueueUsingTwoStacks q = new QueueUsingTwoStacks();
        q.enqueue(42);
        q.dequeue();

        q.enqueue(14);
        q.printFirst();

        q.enqueue(28);
        q.printFirst();

        q.enqueue(60);
        q.enqueue(78);
        q.dequeue();
        q.dequeue();
    }

    Stack firstStack = new Stack();
    Stack secondStack = new Stack();

    void printFirst() {
        moveToOtherStack(firstStack,secondStack);
        Integer result = secondStack.pop();
        secondStack.push(result);
        moveToOtherStack(secondStack,firstStack);
        System.out.println(result);
    }

    void enqueue(int data) {
        firstStack.push(data);
    }

    Integer dequeue() {
        if(secondStack.isEmpty()) {
            move(firstStack,secondStack);
        }
        return secondStack.pop();
    }

    private void moveToOtherStack(Stack source, Stack target) {
        while (!source.isEmpty()) {
            target.push(source.pop());
        }
    }

    private void move(Stack source, Stack target) {
        while (!source.isEmpty()) {
            target.push(source.pop());
        }
    }
}
