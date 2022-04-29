package mutithreads;

/**
 * Created by DBQ on 2016/11/25.
 */
//开启3个窗口卖火车票 总票数100张
public class TestWindow2 {
    public static int ticket = 0;
    public static Object obj = new Object();

    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}

class Window2 extends Thread {

    @Override
    public void run() {

        while (TestWindow2.ticket <= 100) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (TestWindow2.obj) {
                if(TestWindow2.ticket <= 100) {
                    System.out.println(Thread.currentThread().getName() + "售票, 票号为: " + TestWindow2.ticket++);
                }
            }
        }
    }
}
