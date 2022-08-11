package datastructures.queue;

import org.junit.Test;

import java.util.Queue;
import java.util.LinkedList;

public class ReverseQueueFromBeginTest {
    @Test
    public void queueWithFiveElements_ReverseFirstThree() {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        Queue<Integer> x = new ReverseQueueFromBegin(q, 3).reverse();

        System.out.println(x);
    }
}