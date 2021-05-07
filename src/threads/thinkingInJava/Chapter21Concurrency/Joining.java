package threads.thinkingInJava.Chapter21Concurrency;

/**
 * Created by adam on 05/04/2018.
 */

public class Joining {
    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Śpioch",1500),
                grumpy = new Sleeper("Gapcio",1500);

        Joiner dopey = new Joiner("Gburek",sleepy),
                doc = new Joiner("Wesołek", grumpy);

        grumpy.interrupt();
    }
}

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " został przerwany. isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " został wybudzony");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Przerwano");
        }
        System.out.println(getName() + " zakończył połączenie");
    }
}
