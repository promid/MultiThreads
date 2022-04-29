package mutithreads.TestUncaughtExceptionHandler;

/**
 * Created by DBQ on 2016/12/28.
 */
public class Task2 implements Runnable {
    @Override
    public void run() {
        try {
            int numero = Integer.parseInt("TTT");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println("going on!");
        System.out.println("going on!");
        System.out.println("going on!");
        System.out.println("going on!");
        System.out.println("going on!");
        System.out.println("going on!");
    }
}
