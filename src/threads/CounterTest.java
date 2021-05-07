package threads;

public class CounterTest {
    public static void main(String[] args) {
        SynchronizedCounter c1 = new SynchronizedCounter();
        new Thread(new D(c1)).start();
        new Thread(new D(c1)).start();
        System.out.println(c1.getValue());
    }
}

class SynchronizedCounter {
    private int i = 0;

    synchronized void increment() {
        System.out.println("begin increment");
        i++;
        System.out.println("end increment");
    }

    synchronized int getValue() {
        return i;
    }
}

class D implements Runnable {
    private SynchronizedCounter counter;

    D(SynchronizedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.increment();
    }
}