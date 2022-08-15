package leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverageFromDataStream {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int s;

    public MovingAverageFromDataStream(int size) {
        this.s = size;
    }

    public double next(int val) {

        if(q1.size()==s) {
            q1.poll();
        }

        q1.offer(val);

        double avg = 0.0;
        double n = 0;

        while(!q1.isEmpty()) {
            ++n;
            int x = q1.poll();
            avg += x;
            if(q2.size()<s) {
                q2.offer(x);
            }
        }

        q1 = q2;

        q2 = new LinkedList<>();

        return avg/n;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */