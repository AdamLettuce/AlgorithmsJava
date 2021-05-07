package threads.thinkingInJava.Chapter21Concurrency.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by adam on 04/04/2018.
 */
public class Exercise5 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(50);
        List<Future<Integer>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(executor.submit(new SimpleThread3(i)));
        }

        for (Future<Integer> result : results) {
            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                executor.shutdown();
            }
        }
    }
}

class SimpleThread3 implements Callable<Integer> {

    private int id = 1;

    @Override
    public Integer call() throws Exception {
        return id;
    }

    public SimpleThread3(int i) {
        id = i;
    }

}
