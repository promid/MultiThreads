package test.TestDaemon;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by DBQ on 2016/12/22.
 */
public class Main {
    public static void main(String[] args) {
        BlockingDeque<Event> deque = new LinkedBlockingDeque<>();
        WriterTask writer=new WriterTask(deque);
        for (int i=0; i<3; i++){
            Thread thread=new Thread(writer);
            thread.start();
        }
        CleanerTask cleaner=new CleanerTask(deque);
        cleaner.start();
    }

}
