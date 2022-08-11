package datastructures.stack;

public class StackDynamicSizeUsingArray implements MyStack {
    public static void main(String[] args) {
        StackDynamicSizeUsingArray s1 = new StackDynamicSizeUsingArray();

        System.out.println(s1);

        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        System.out.println(s1);

        s1.push(5);
        System.out.println(s1);

        System.out.println();
        System.out.println("pop: " + s1.pop());

        System.out.println("pop: " + s1.pop());
        System.out.println("pop: " + s1.pop());
        System.out.println("pop: " + s1.pop());

        System.out.println();
        System.out.println(s1);

        System.out.println();
        System.out.println("pop: " + s1.pop());
        System.out.println("-");
        System.out.print(s1);
        System.out.println("-");
        System.out.println(s1.isEmpty());
    }

    int[] data;
    int top = -1;

    public StackDynamicSizeUsingArray() {
        data = new int[4];
    }

    @Override
    public int pop() {
        if(isEmpty()) {
            throw new IllegalArgumentException();
        }
        if(top<data.length/4) {
            data = copyData(data.length/2);
        }
        int result = data[top];
        data[top] = 0;
        --top;
        return result;
    }

    private int[] copyData(int size) {
        int[] newData = new int[size];
        if (top + 1 >= 0) System.arraycopy(data, 0, newData, 0, top + 1);
        return newData;
    }

    @Override
    public int peek() {
        if(isEmpty()) {
            throw new IllegalArgumentException();
        }
        return data[top];
    }

    @Override
    public void push(int i) {
        if(isFull()) {
            data = copyData(data.length*2);
        }
        data[++top] = i;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = data.length-1; i >= 0; i--) {
            stringBuilder.append(data[i]).append("\n");
        }
        return stringBuilder.toString();
    }
}
