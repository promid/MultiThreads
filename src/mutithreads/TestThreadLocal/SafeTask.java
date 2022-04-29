package mutithreads.TestThreadLocal;

import java.util.Date;

/**
 * Created by DBQ on 2016/12/28.
 */
public class SafeTask {
    ThreadLocal<Date> date = new ThreadLocal<>();
}
