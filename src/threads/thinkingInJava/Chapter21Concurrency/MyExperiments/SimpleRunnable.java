package threads.thinkingInJava.Chapter21Concurrency.MyExperiments;

import java.util.concurrent.TimeUnit;

/**
 * Created by adam on 10/04/2018.
 */
public class SimpleRunnable {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SimpleTask());
        TimeUnit.SECONDS.sleep(1);
        thread.start();
        thread.interrupt();
    }
}

class SimpleTask implements Runnable {
    @Override
    public void run() {
//        while(!Thread.currentThread().isInterrupted()) {
//            System.out.println("Test");
//        }

            try {
                while(true) {
                    System.out.println("test");
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }

}
