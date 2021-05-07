package threads.thinkingInJava.Chapter21Concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by adam on 10/04/2018.
 */
public class InterruptingIdiom {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Blocked3());
        t.start();
//        TimeUnit.MILLISECONDS.sleep(500);
//        TimeUnit.MILLISECONDS.sleep(1000);
//        TimeUnit.MILLISECONDS.sleep(1500);
        t.interrupt();
    }
}

class NeedsCleanup {
    private final int id;

    public NeedsCleanup(int id) {
        this.id = id;
        System.out.println("NeedsCleanup " + id);
    }

    public void cleanup() {
        System.out.println("Porządkowanie " + id);
    }
}

class Blocked3 implements Runnable {
    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                NeedsCleanup n1 = new NeedsCleanup(1);
                try {
                    System.out.println("Drzemka");
                    TimeUnit.SECONDS.sleep(1);
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    try {
                        System.out.println("Obliczenia");
                        for (int i = 0; i < 2500000; i++) {
                            d=d+(Math.PI+Math.E)/d;
                        }
                        System.out.println("Zakończono czasochłonne obliczenia");
                    } finally {
                        n2.cleanup();
                    }
                } finally {
                    n1.cleanup();
                }
            }
            System.out.println("Wyjście przewidziane w teście while()");
        } catch (InterruptedException e) {
            System.out.println("Wyjście wymuszone wyjątkiem InterruptedException");
        }
    }
}

