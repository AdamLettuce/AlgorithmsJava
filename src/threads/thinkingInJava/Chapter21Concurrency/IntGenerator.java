package threads.thinkingInJava.Chapter21Concurrency;

/**
 * Created by adam on 07/04/2018.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
