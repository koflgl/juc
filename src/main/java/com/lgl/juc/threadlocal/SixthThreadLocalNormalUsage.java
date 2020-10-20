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
 * @author lgl 2020/10/20 19:56
 * @since 1.0
 */
public class SixthThreadLocalNormalUsage {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                String date = new SixthThreadLocalNormalUsage().date(finalI);
                System.out.println(date);
            });
        }
        threadPool.shutdown();
    }
    public String date(int seconds) {
        //参数的单位是毫秒，从1970.1.1 00:00:00 GMT计时
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = ThreadSafeFormatter.dateFormatThreadLocal.get();
        return dateFormat.format(date);
    }
}
class ThreadSafeFormatter {

    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
}