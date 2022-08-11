package datastructures.stack;

public class StackFixedSizeUsingArray implements MyStack {
    public static void main(String[] args) {

//        StackFixedSizeUsingArray s0 = new StackFixedSizeUsingArray(-1);
        StackFixedSizeUsingArray s0 = new StackFixedSizeUsingArray(0);
        s0.push(1);

        StackFixedSizeUsingArray s1 = new StackFixedSizeUsingArray(2);
        s1.push(1);
        s1.push(2);
        try {
            s1.push(3);
            System.out.println("not ok");
        } catch (IllegalArgumentException e) {
            System.out.println("ok");
        }

        StackFixedSizeUsingArray s = new StackFixedSizeUsingArray(3);
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.peek()==3);
        System.out.println(s.peek()==3);
        System.out.println(s.peek()==3);
        System.out.println(s);
        System.out.println(3==s.pop());
        System.out.println(2==s.pop());
        System.out.println(1==s.pop());


    }

    int[] data;
    int top = -1;

    public StackFixedSizeUsingArray(int n) {
        data = new int[n];
    }

    public int pop() {
        if(isEmpty()) {
            throw new IllegalArgumentException();
        }
        return data[top--];
    }

    public int peek() {
        if(isEmpty()) {
            throw new IllegalArgumentException();
        }
        return data[top];
    }

    public void push(int i) {
        if(isFull()) {
            throw new IllegalArgumentException();
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
        StringBuilder sb = new StringBuilder();
        for (int i = top; i >= 0; i--) {
            sb.append(data[i]).append("\n");
        }
        return sb.toString();
    }
}
