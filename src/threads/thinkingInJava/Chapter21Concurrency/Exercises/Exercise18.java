package threads.thinkingInJava.Chapter21Concurrency.Exercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by adam on 10/04/2018.
 */
public class Exercise18 {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        LongLastingTask command = new LongLastingTask();
//        Future<?> f = executorService.submit(command);
//        Thread.currentThread().interrupt();
        executorService.execute(command);
        command.interrupt();
        executorService.shutdownNow();
    }
}

class LongLastingTask extends Thread {
    @Override
    public void run() {
        new LongLasting().doIt();
    }
}

class LongLasting {
    void doIt() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
