package threads.thinkingInJava.Chapter21Concurrency.Exercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by adam on 11/04/2018.
 */
public class Exercise22_ActiveWaiting {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        SleepingForAWhile sleepingForAWhile = new SleepingForAWhile();
        exec.execute(sleepingForAWhile);
        exec.execute(new WatchingSleeper(sleepingForAWhile));
        TimeUnit.MILLISECONDS.sleep(100);
        exec.shutdownNow();
    }
}

//Version 2 - wait

class SleepingForAWhile implements Runnable {
    private boolean flag = false;

    @Override
    public void run() {
        try {
            System.out.println("zapadam w sen...");
            TimeUnit.MILLISECONDS.sleep(80);
            enable();
            System.out.println("pobudka!");
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
    }

    public synchronized void enable() {
        flag = true;
        notifyAll();
    }

    public synchronized void disable() {
        flag = false;
        notifyAll();
    }

    public synchronized boolean isEnabled() {
        return flag;
    }
}

class WatchingSleeper implements Runnable {

    private SleepingForAWhile sleepingForAWhile;

    public WatchingSleeper(SleepingForAWhile sleepingForAWhile) {
        this.sleepingForAWhile = sleepingForAWhile;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (sleepingForAWhile) {
                    while(!sleepingForAWhile.isEnabled()) {
                        sleepingForAWhile.disable();
                        System.out.println("Zmiana");
                        sleepingForAWhile.wait();
                    }
                }
                TimeUnit.MILLISECONDS.sleep(5);
            }
        } catch (InterruptedException e) {
            System.out.println("koniec");
        }
    }

}
/*

//Version 1 - active waiting
class SleepingForAWhile implements Runnable {
    private boolean flag = false;

    @Override
    public void run() {
        try {
            System.out.println("zapadam w sen...");
            TimeUnit.MILLISECONDS.sleep(80);
            System.out.println("pobudka!");
            enable();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void enable() {
        flag = true;
    }

    public synchronized void disable() {
        flag = false;
    }

    public synchronized boolean isEnabled() {
        return flag;
    }
}

class WatchingSleeper implements Runnable {

    private SleepingForAWhile sleepingForAWhile;

    public WatchingSleeper(SleepingForAWhile sleepingForAWhile) {
        this.sleepingForAWhile = sleepingForAWhile;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                if (sleepingForAWhile.isEnabled()) {
                    System.out.println("Zmiana");
                    sleepingForAWhile.disable();
                } else {
                    System.out.println("Czekam...");
                }
                TimeUnit.MILLISECONDS.sleep(5);
            }
        } catch (InterruptedException e) {
            System.out.println("koniec");
        }
    }

}
*/