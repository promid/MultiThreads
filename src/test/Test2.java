package test;

import java.util.Date;

/**
 * Created by DBQ on 2016/12/22.
 */
public class Test2 extends Thread {


    public static void main(String[] args) {
        ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
            @Override
            protected Date initialValue() {
                return super.initialValue();
            }
        };


    }
}


