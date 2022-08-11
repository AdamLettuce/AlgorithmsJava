package datastructures.stack;

public class Stack {

    StackElement top = null;
    private int count = 0;

    public void push(int data) {
        StackElement se = new StackElement(data);
        ++count;
        if(isEmpty()) {
            top = se;
        } else {
            se.next = top;
            top = se;
        }

    }

    public int size() {
        return count;
    }

    public void clear() {
        top = null;//TODO: think is this really ok, shouldn't I iterate?
    }

    public void addAll(Stack other) {
        StackElement e= other.top;
        while(e!=null) {
            push(e.data);
            e=e.next;
        }
    }

    public Integer pop() {
        if(!isEmpty()) {
            int data = top.data;
            top = top.next;
            --count;
            return data;
        }
        return null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Integer first() {
        if(!isEmpty()) {
            return top.data;
        }
        return null;
    }

    @Override
    public String toString() {
        if(isEmpty()) {
            return "Empty";
        }
        StackElement i = top;
        StringBuilder stringBuilder = new StringBuilder();
        while(i!=null) {
            stringBuilder.append(i).append(",");
            i = i.next;
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}