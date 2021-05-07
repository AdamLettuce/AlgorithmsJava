package threads.thinkingInJava.Chapter21Concurrency.MyExperiments;


import java.util.Random;
import java.util.concurrent.*;

public class FutureThread {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ParentTask(new MyTask()));
        executorService.shutdown();
    }
}

class ParentTask implements Runnable {

    MyTask task;

    private long t0 = System.currentTimeMillis();

    public ParentTask(MyTask task) {
        this.task = task;
    }

    @Override
    public void run() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> myTaskResult = executorService.submit(task);

//        myTaskResult.cancel(false);//Parent cancelled
//        myTaskResult.cancel(true);//Parent cancelled

        while (!myTaskResult.isDone()) {
            try {
//                myTaskResult.cancel(false);//Parent cancelled
//                myTaskResult.cancel(true);//Parent cancelled
                TimeUnit.MILLISECONDS.sleep(100);
//                myTaskResult.cancel(false);//Parent cancelled+MyTask was interrupted
//                myTaskResult.cancel(true);//Parent cancelled+MyTask was interrupted
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            myTaskResult.cancel(false);//Parent cancelled+MyTask was interrupted
            myTaskResult.cancel(true);//Parent cancelled+MyTask was interrupted
            System.out.println("Waiting for result..." + (System.currentTimeMillis() - t0) / 1000.0);
        }

        myTaskResult.cancel(false);//here it won't fail as myTaskResult has been done - no exception
        myTaskResult.cancel(true);//here it won't fail as myTaskResult has been done - no exception

        Integer realResult = null;
        try {
            realResult = myTaskResult.get();
        } catch (CancellationException e) {
            System.out.println("Parent cancelled");
        } catch (InterruptedException e) {
            System.out.println("Parent interrupted");
        } catch (ExecutionException e) {
            System.out.println("Other");
        }
        System.out.println(realResult);

        executorService.shutdownNow();
    }
}

class MyTask implements Callable<Integer> {
    @Override
    public Integer call() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("MyTask was interrupted");
        }
        return new Random().nextInt(100);
    }
}