package threads.thinkingInJava.Chapter21Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by adam on 05/04/2018.
 */

public class CapturedUncaughtException {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}

class ExceptionThread2 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("wywołanie run() dla " + t);
        System.out.println("pow = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }

}

class MyUnucaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("przechwycono " + e + " dla:  " + t);
    }
}

class HandlerThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        System.out.println(this + " tworzy nowy obiekt Thread");
        Thread t = new Thread(r);
        System.out.println("utworzono " + t);
        t.setUncaughtExceptionHandler(new MyUnucaughtExceptionHandler());
        System.out.println("pow = " + t.getUncaughtExceptionHandler());
        return t;
    }
}