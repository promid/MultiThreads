package test.TestDaemon;


import java.util.Date;
import java.util.concurrent.BlockingDeque;

/**
 * Created by DBQ on 2016/12/22.
 */
public class WriterTask implements Runnable {

    private BlockingDeque<Event> deque;

    public WriterTask(BlockingDeque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            Event event = new Event();
            event.setDate(new Date());

            event.setEvent(String.format("The thread %s has generated an event", Thread.currentThread().getId()));

            deque.addFirst(event);
            try {
                //TimeUnit.SECONDS.sleep(1);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}

