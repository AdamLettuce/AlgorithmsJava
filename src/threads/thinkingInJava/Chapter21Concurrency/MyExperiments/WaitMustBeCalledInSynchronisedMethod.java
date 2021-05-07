package threads.thinkingInJava.Chapter21Concurrency.MyExperiments;

/**
 * Created by adam on 11/04/2018.
 */
public class WaitMustBeCalledInSynchronisedMethod {

//    private Integer integer = new Integer(10);

    public static void main(String[] args) {
        WaitMustBeCalledInSynchronisedMethod instance = new WaitMustBeCalledInSynchronisedMethod();
//        instance.notSynchronisedWait();
        instance.synchronisedWait();
        System.out.println("Waiting...");
        System.out.println("Waiting...");
        System.out.println("Waiting...");
        instance.synchronisedNotifyAll();
        System.out.println("Finished waiting..");
    }

    private void notSynchronisedWait() {
        Integer integer = new Integer(10);
        try {
            integer.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IllegalMonitorStateException e) {
            System.out.println("IllegalMonitorStateException");
        }
        System.out.println("notSynchronisedWait end");
    }

    private void synchronisedWait() {
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IllegalMonitorStateException e) {
            System.out.println("IllegalMonitorStateException");
        }
        System.out.println("synchronisedWait end");
    }

    private void synchronisedNotifyAll() {
        synchronized (this) {
            this.notifyAll();
        }
    }
}
