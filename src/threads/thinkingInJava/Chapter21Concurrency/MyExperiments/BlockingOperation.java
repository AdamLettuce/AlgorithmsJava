package threads.thinkingInJava.Chapter21Concurrency.MyExperiments;

import java.util.concurrent.TimeUnit;

/**
 * Created by adam on 10/04/2018.
 */
public class BlockingOperation {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new BlockingTask());
        t.start();
        TimeUnit.MILLISECONDS.sleep(100);
        t.interrupt();
    }
}


class BlockingTask implements Runnable {
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("locked");
        }
    }
}