package com.lgl.juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * description
 * </p>
 *
 * @author lgl 2020/10/20 19:46
 * @since 1.0
 */
public class ThirdThreadLocalNormalUsage {
    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        Set set=new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                String date = new ThirdThreadLocalNormalUsage().date(finalI);
                System.out.println(date);
                set.add(date);
            });
        }
        Thread.sleep(5000);
        System.out.println(set.size());
        threadPool.shutdown();
    }

    public String date(int seconds) {
        //参数的单位是毫秒，从1970.1.1 00:00:00 GMT计时
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
