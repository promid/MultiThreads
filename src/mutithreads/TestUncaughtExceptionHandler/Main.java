package mutithreads.TestUncaughtExceptionHandler;

/**
 * Created by DBQ on 2016/12/28.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
        thread.join();
        Thread thread1 = new Thread(new Task2());
        thread1.start();
    }
}
