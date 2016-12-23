package test;

/**
 * Created by DBQ on 2016/11/25.
 */
public class TestWindow3 {
    public static int ticket = 100;

    public static void main(String[] args) {
        Window3 w3 = new Window3();
        Thread t1 = new Thread(w3);
        Thread t2 = new Thread(w3);
        Thread t3 = new Thread(w3);
        t1.start();
        t2.start();
        t3.start();
    }

}

class Window3 implements Runnable {

    @Override
    public void run() {
        while (TestWindow3.ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sale();
        }
    }

    public synchronized void sale() {
        if (TestWindow3.ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ": " + TestWindow3.ticket--);
        }
    }
}
