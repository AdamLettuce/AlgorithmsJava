package threads.thinkingInJava.Chapter21Concurrency.Exercises;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by adam on 04/04/2018.
 */
public class Exercise6 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new SimpleTask());
        }
        executorService.shutdown();
    }
}

class SimpleTask implements Runnable {
    @Override
    public void run() {
        Integer random = new Random().nextInt(1000);
        try {
            System.out.println(String.format("Sleeping for %d[ms]",random));
            TimeUnit.MILLISECONDS.sleep(random);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
