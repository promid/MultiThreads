package mutithreads;

/**
 * Created by DBQ on 2016/11/25.
 */
public class TestWindow {

    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.start();
        t2.start();
        t3.start();
    }
}

// 实现的方式避免了单继承的局限性
// 如果多个线程要操作同一份资源, 更适合使用实现的方式
class Window implements Runnable {

    int ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "售票, 票号为: " + ticket--);
                }
            }
        }
    }
}
