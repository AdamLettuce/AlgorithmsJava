package threads.thinkingInJava.Chapter21Concurrency.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by adam on 08/04/2018.
 */
public class Exercise19_OrnamentalGarden {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            Entrance1 command = new Entrance1(i);
            exec.execute(command);
        }

        TimeUnit.SECONDS.sleep(3);

        exec.shutdownNow();
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("Niektóre zadania wciąż działają!");
        }
        System.out.println("Razem: " + Entrance1.getTotalCount());
        System.out.println("Suma wejść: " + Entrance1.sumEntrances());
    }
}

class Count1 {
    private int count = 0;
    private Random rand = new Random(47);

    public synchronized int increment() {
        int temp = count;
        if (rand.nextBoolean()) {
            Thread.yield();
        }
        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }
}

class Entrance1 extends Thread {
    private static Count1 count = new Count1();
    private static List<Entrance1> entrances = new ArrayList<>();
    private int number = 0;
    private final int id;

    public Entrance1(int id) {
        this.id = id;
        entrances.add(this);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
//        while (!Thread.interrupted()) {
                synchronized (this) {
                    ++number;
                }

                System.out.println(this + " Razem: " + count.increment());

                TimeUnit.MILLISECONDS.sleep(100);

            }
        } catch (InterruptedException e) {
            System.out.println("Przerwano uśpienie");
        }
        System.out.println("Zatrzymywanie: " + this);
    }

    public synchronized int getValue() {
        return number;
    }

    public String toString() {
        return "Wejście " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance1 entrance : entrances) {
            sum += entrance.getValue();
        }
        return sum;
    }
}