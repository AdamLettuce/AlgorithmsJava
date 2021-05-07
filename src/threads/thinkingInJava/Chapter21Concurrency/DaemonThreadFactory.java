package threads.thinkingInJava.Chapter21Concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * Created by adam on 04/04/2018.
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
