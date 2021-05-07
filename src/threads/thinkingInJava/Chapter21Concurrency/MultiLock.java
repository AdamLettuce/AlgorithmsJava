package threads.thinkingInJava.Chapter21Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by adam on 10/04/2018.
 */
public class MultiLock {
    public synchronized void f1(int count, int id) {
        if(count-->0){
            System.out.println("f1() wywołuje f2() z licznikiem " + count + " , id = " + id);
            f2(count,id);
        }
    }

    private synchronized void f2(int count, int id) {
        if(count-->0) {
            System.out.println("f2() wywołuje f1() z licznikiem " + count + ", id = " + id);
            f1(count,id);
        }
    }

    public static void main(String[] args) {
        final MultiLock multiLock = new MultiLock();
        Thread t1 = new Thread() {
            public void run() {
                multiLock.f1(10,1);
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                multiLock.f2(10,2);
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(t1);
        executorService.execute(t2);
        executorService.shutdown();
    }
}
