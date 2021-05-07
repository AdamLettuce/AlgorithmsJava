package threads.thinkingInJava.Chapter21Concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by adam on 04/04/2018.
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("Przerwanie sleep()");
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("Uruchomiono wszystkie demony");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
