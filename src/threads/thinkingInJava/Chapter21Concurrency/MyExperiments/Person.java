package threads.thinkingInJava.Chapter21Concurrency.MyExperiments;

/**
 * Created by adam on 07/04/2018.
 */
public class Person implements Runnable {
    private Bathroom bathroom;
    private String name;

    public Person(Bathroom bathroom, String name) {
        this.bathroom = bathroom;
        this.name = name;
    }

    @Override
    public void run() {
        bathroom.takeShower(name);
    }
}
