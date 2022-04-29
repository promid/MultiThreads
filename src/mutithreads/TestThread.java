package mutithreads;

/**
 * Created by DBQ on 2016/11/25.
 */
public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        SubThread s = new SubThread();
        Thread st = new Thread(s);
        st.setPriority(Thread.MAX_PRIORITY);
        st.start();
        for (int i = 0; i < 100; i++) {
//            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + ": " + i);
//            if(i % 10 == 0){
//                Thread.yield();
//            }
            if (i == 10){
                st.join(); // 当前进程停止执行, 直到 st 进程执行完毕, 当前进程再开始执行
                System.out.println(st.isAlive()); // false: st 执行完了才会执行这句
            }
        }
    }
}

class SubThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
