package threads.thinkingInJava.Chapter21Concurrency.Exercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by adam on 04/04/2018.
 */
public class Exercise2 {
    public static void main(String[] args) {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        ExecutorService executor = Executors.newCachedThreadPool();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.execute(new SimpleThread1(i));
        }
        executor.shutdown();
    }
}

class SimpleThread1 implements Runnable {

    private int id = 1;

    public SimpleThread1(int i) {
        id= i;
        System.out.println("Początek");
    }

    @Override
    public void run() {
        System.out.println("Czesc " + id);
        Thread.yield();
        System.out.println("Stefan " + id);
        Thread.yield();
        System.out.println("Co u Ciebie " + id);
        Thread.yield();
        System.out.println("Do widzenia " + id);
    }
}
