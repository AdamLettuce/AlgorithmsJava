package threads.thinkingInJava.Chapter21Concurrency.Exercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by adam on 11/04/2018.
 */

public class Exercise21 {
    public static void main(String[] args) throws InterruptedException {
        FlyingBallTask flyingBallTask = new FlyingBallTask();
        CatchBallTask catchBallTask = new CatchBallTask(flyingBallTask);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(flyingBallTask);
        exec.execute(catchBallTask);
        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }

}

class FlyingBallTask implements Runnable {

    private boolean isFlying = true;

    @Override
    public void run() {
        synchronized (this) {
            try {
                while (!Thread.interrupted()) {

                    System.out.println("Lecęęęęęęęę.....");
                    TimeUnit.MILLISECONDS.sleep(200);
                    if (isFlying) {
                        wait();
                    }
                }

            } catch (InterruptedException e) {
                System.out.println("Przerwano rzut");
            }
        }
    }

    public synchronized boolean isFlying() {
        return isFlying;
    }

    public synchronized void catchMe() {
        this.isFlying = false;
    }

}

class CatchBallTask implements Runnable {

    private FlyingBallTask flyingBallTask;

    public CatchBallTask(FlyingBallTask flyingBallTask) {
        this.flyingBallTask = flyingBallTask;
    }

    @Override
    public void run() {
        synchronized (flyingBallTask) {
            try {
                flyingBallTask.catchMe();
                System.out.println("Złapałem piłkę");
                TimeUnit.MILLISECONDS.sleep(200);
                if (!flyingBallTask.isFlying()) {
                    System.out.println("Odrzucam");
                    flyingBallTask.notifyAll();
                }
            } catch (InterruptedException e) {
                System.out.println("Przerwano łapanie");
            }
        }
    }
}

/*
public class Exercise21 {
    public static void main(String[] args) throws InterruptedException {
        Window window = new Window();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new CloseWindowTask(window));
        exec.execute(new OpenWindowTask(window));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}

class Window {
    private boolean isOpen = false;

    public synchronized void opened() {
        isOpen = true;
        notifyAll();
    }

    public synchronized void closed() {
        isOpen = false;
        notifyAll();
    }

    public synchronized void waitForOpening() throws InterruptedException {
        while (!isOpen) {
            wait();
        }
    }

    public synchronized void waitForClosing() throws InterruptedException {
        while (isOpen) {
            wait();
        }
    }
}

class OpenWindowTask implements Runnable {

    private Window window;

    public OpenWindowTask(Window window) {
        this.window = window;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Otwieranie! ");
                TimeUnit.MILLISECONDS.sleep(200);
                window.opened();
                window.waitForClosing();
            }
        } catch (InterruptedException e) {
            System.out.println("Wyjście wymuszone przerwaniem");
        }
        System.out.println("Koniec otwierania okna");
    }
}

class CloseWindowTask implements Runnable {

    private Window window;

    public CloseWindowTask(Window window) {
        this.window = window;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                window.waitForOpening();
                System.out.println("Zamykanie! ");
                TimeUnit.MILLISECONDS.sleep(200);
                window.closed();
            }
        } catch (InterruptedException e) {
            System.out.println("Wyjście wymuszone prerwaniem");
        }
        System.out.println("Koniec zadania zamykania");
    }
}
*/