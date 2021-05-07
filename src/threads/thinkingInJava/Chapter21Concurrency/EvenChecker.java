package threads.thinkingInJava.Chapter21Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by adam on 07/04/2018.
 */
public class EvenChecker implements Runnable {

    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if(val%2!=0){
                System.out.println(val + " nieparzysta!");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator generator, int count) {
        System.out.println("Aby zakończyć naciśnij ctrl+c");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(generator,i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator generator) {
        test(generator,10);
    }
}
