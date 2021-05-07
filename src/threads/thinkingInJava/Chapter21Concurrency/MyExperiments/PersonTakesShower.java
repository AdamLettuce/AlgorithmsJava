package threads.thinkingInJava.Chapter21Concurrency.MyExperiments;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by adam on 07/04/2018.
 */
public class PersonTakesShower {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Bathroom bathroom = new Bathroom();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Person(bathroom, "Madzia"));
            executorService.execute(new Person(bathroom, "Adam"));
            executorService.execute(new Person(bathroom, "Kuba"));
        }
        executorService.shutdown();
    }
}
