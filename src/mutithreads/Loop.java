package mutithreads;

import java.util.concurrent.TimeUnit;

/**
 * @author Bei
 * @date 12/20/17
 */
public class Loop {

    /*
    Thread有守护线程和非守护线程之分。
    守护线程在主线程运行结束后，也会结束运行，而非守护线程不会结束。
    线程默认都是非守护线程。可以使用thread.setDeamon方法来设置。
    system.exit(0); 代表退出进程，无论什么线程都退出。
    */

    public static void main(String[] args) {
        Sub sub = new Sub();
        Thread t = new Thread(sub);
        t.setDaemon(true);
        t.start();
        System.exit(0);
    }

    public static class Sub extends Thread {

        @Override
        public void run() {
            while (true) {
                System.out.println("123");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
