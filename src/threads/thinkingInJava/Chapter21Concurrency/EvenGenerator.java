package threads.thinkingInJava.Chapter21Concurrency;

/**
 * Created by adam on 07/04/2018.
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
//        currentEvenValue+=2;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
