package mutithreads.TestDaemon;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by DBQ on 2016/12/22.
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new T1());
        T2 t2 = new T2();
        t1.start();
        t2.start();
        Thread.sleep(5000);
        t1.interrupt();
    }
}

class T1 implements Runnable {

    @Override
    public void run() {
        while (true) {
            if(Thread.currentThread().isInterrupted()){
                break;
            }
        }
    }
}

class T2 extends Thread {

    public T2() {
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true){
            System.out.println("Daemon" + new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
