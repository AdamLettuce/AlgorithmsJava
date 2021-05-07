package threads.thinkingInJava.Chapter21Concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by adam on 09/04/2018.
 */
public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Przerwanie " + r.getClass().getName());
        f.cancel(true);
        System.out.println("Nakaz przerwania wysłany do " + r.getClass().getName());
    }

    public static void main(String[] args) throws Exception {
//        test(new SleepBlocked());
        test(new IOBlocked(System.in));
//        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Opuszczanie programu (System.exit(0))");
        System.exit(0);
    }
}

class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch(InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Opuszczanie metody SleepBlocked.run()");
    }
}

class IOBlocked implements Runnable {
    private InputStream in;
    public IOBlocked(InputStream in) {
        this.in=in;
    }

    @Override
    public void run() {
        try {
            System.out.println("Oczekiwanie na read(): ");
            in.read();
        } catch (IOException e) {
            boolean interrupted = Thread.currentThread().isInterrupted();
            if(interrupted) {
                System.out.println("Przerwany w zawieszeniu na operacji wejścia-wyjścia");
            } else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Opuszczanie metody IOBlocked.run()");
    }
}

class SynchronizedBlocked implements Runnable {

    public synchronized void f() {
        while(true) {
//            System.out.println("Wywołano f()");
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread() {
            @Override
            public void run() {
                f();
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("Próba wywołania f()");
        f();
        System.out.println("Opuszczanie metody SynchronizedBlock.run()");
    }
}
