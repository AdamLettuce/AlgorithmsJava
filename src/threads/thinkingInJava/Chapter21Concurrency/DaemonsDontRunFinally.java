package threads.thinkingInJava.Chapter21Concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by adam on 05/04/2018.
 */
public class DaemonsDontRunFinally {
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}

class ADaemon implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Uruchomienie demona ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Wyjście przez wyjątek InterruptedException");
        } finally {
            System.out.println("Czy to się uruchomi?");
        }
    }
}
