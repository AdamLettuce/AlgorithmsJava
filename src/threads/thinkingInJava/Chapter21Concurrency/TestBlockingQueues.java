//: concurrency/TestBlockingQueues.java
// {RunByHand}
package threads.thinkingInJava.Chapter21Concurrency;


import java.util.concurrent.*;
import java.io.*;

class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;
    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }
    public void add(LiftOff lo) {
        try {
            rockets.put(lo);
        } catch(InterruptedException e) {
            System.out.println("Przerwanie w metodzie put()");
        }
    }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run(); // Uruchomienie zadania we własnym wątku
            }
        } catch(InterruptedException e) {
            System.out.println("Obudzony z take()");
        }
        System.out.println("Kończenie zadania LiftOffRunner");
    }
}

public class TestBlockingQueues {
    static void getkey() {
        try {
            // Kompensacja ró¿nicy pomiêdzy systemami Windows i Linux
            // odnoœnie znaku generowanego przez naciœniêcie klawisza Enter:
            new BufferedReader(
                    new InputStreamReader(System.in)).readLine();
        } catch(java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void getkey(String message) {
        System.out.println(message);
        getkey();
    }
    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for(int i = 0; i < 5; i++)
            runner.add(new LiftOff(5));
        getkey("Naciśnij 'Enter' (" + msg + ")");
        t.interrupt();
        System.out.println("Koniec testu " + msg);
    }
    public static void main(String[] args) {
        test("LinkedBlockingQueue", // Nieograniczony rozmiar
                new LinkedBlockingQueue<LiftOff>());
        test("ArrayBlockingQueue", // Sta³y rozmiar
                new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue", // Kolejka jednoelementowa
                new SynchronousQueue<LiftOff>());
    }
} ///:~
