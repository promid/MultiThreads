package mutithreads;

/**
 * Created by DBQ on 2016/12/22.
 */
public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Threada t = new Threada();
        t.start();
        Thread.sleep(3000);
        t.interrupt();
    }
}

class Threada extends Thread {
    public void run() {
        while (true) {
            if (Thread.interrupted()) {
                System.out.println("Someone interrupted me.");
            } else {
                System.out.println("Going...");
            }
            long now = System.currentTimeMillis();
            while (System.currentTimeMillis() - now < 1000) {
                // 为了避免Thread.sleep()而需要捕获InterruptedException而带来的理解上的困惑,
                // 此处用这种方法空转1秒
            }
        }
    }
}

