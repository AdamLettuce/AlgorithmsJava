package datastructures.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueueFromBegin {

    private int K;
    private Queue<Integer> queue;

    public ReverseQueueFromBegin(Queue<Integer> queue, int K) {
        this.K = K;
        this.queue = queue;
    }

    public Queue<Integer> reverse() {
        if(queue == null || queue.isEmpty() || K<=0) {
            throw new IllegalArgumentException();
        }

        int k = Integer.min(K,queue.size());
        Stack<Integer> helper = new Stack<>();

        for (int i = 0; i < k; i++) {
            helper.push(queue.poll());
        }

        while(!helper.empty()) {
            queue.add(helper.pop());
        }

        for (int i = 0; i < queue.size()-K; i++) {
            queue.add(queue.poll());
        }

        return queue;
    }
}
