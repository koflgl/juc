package com.lgl.juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * description
 * </p>
 *
 * @author lgl 2020/10/20 19:55
 * @since 1.0
 */
public class FifthThreadLocalNormalUsage {
    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                String date = new FifthThreadLocalNormalUsage().date(finalI);
                System.out.println(date);
            });
        }
        threadPool.shutdown();
    }

    public String date(int seconds) {
        //参数的单位是毫秒，从1970.1.1 00:00:00 GMT计时
        Date date = new Date(1000 * seconds);
        String s = null;
        synchronized (FifthThreadLocalNormalUsage.class) {
            s = dateFormat.format(date);
        }
        return s;
    }
}
