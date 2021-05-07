package threads.thinkingInJava.Chapter21Concurrency.Exercises;

/**
 * Created by adam on 04/04/2018.
 */
public class Exercise1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new SimpleThread(i));
            t.start();
        }
    }
}

class SimpleThread implements Runnable {

    private int id = 1;

    public SimpleThread(int i) {
        id= i;
        System.out.println("Początek");
    }

    @Override
    public void run() {
        System.out.println("Czesc " + id);
        Thread.yield();
        System.out.println("Stefan " + id);
        Thread.yield();
        System.out.println("Co u Ciebie " + id);
        Thread.yield();
        System.out.println("Do widzenia " + id);
    }
}
