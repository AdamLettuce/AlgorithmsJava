package threads.thinkingInJava.Chapter21Concurrency;

/**
 * Created by adam on 12/04/2018.
 */
//: concurrency/LiftOff.java
// Demonstracja interfejsu Runnable.

public class LiftOff implements Runnable {
    protected int countDown = 10; // Wartoœæ domyœlna
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Start!") + "), ";
    }
    public void run() {
        while(countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
} ///:~
