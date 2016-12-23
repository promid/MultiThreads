package test;

/**
 * Created by DBQ on 2016/12/22.
 */
public class TestInterrupt2 extends Thread{
    private Thread parent;
    public TestInterrupt2(Thread parent){
        this.parent = parent;
    }

    public void run() {
        while (true) {
            System.out.println("sub thread is running...");
            long now = System.currentTimeMillis();
            while (System.currentTimeMillis() - now < 2000) {
                // 为了避免Thread.sleep()而需要捕获InterruptedException而带来的理解上的困惑,
                // 此处用这种方法空转2秒
            }
            parent.interrupt();
        }
    }

    public static void main(String[] args){
        TestInterrupt2 t = new TestInterrupt2(Thread.currentThread());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println("Parent thread will end...");
        }
        System.out.println("Parent thread ends.");
    }
}
