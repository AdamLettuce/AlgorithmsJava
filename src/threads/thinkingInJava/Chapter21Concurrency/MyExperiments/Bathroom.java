package threads.thinkingInJava.Chapter21Concurrency.MyExperiments;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by adam on 07/04/2018.
 */
public class Bathroom {

    private int counter = 0;

    private ReentrantLock lock = new ReentrantLock();

    /*
    public synchronized void takeShower(String person) {
        ++counter;
        System.out.println(counter + " " + person + " is taking a shower.");
    }
    */
    public void takeShower(String person) {
        lock.lock();

        try {
            sing();
            ++counter;
            System.out.println(counter + " " + person + " is taking a shower");
        } finally {
            lock.unlock();
        }
    }

    public void sing() {
        lock.lock();
        try {
            System.out.println(lock.getHoldCount());
        } finally {
            lock.unlock();
        }
    }
}
