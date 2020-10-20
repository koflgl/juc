package com.lgl.juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * description
 * </p>
 *
 * @author lgl 2020/10/20 19:44
 * @since 1.0
 */
public class SecondThreadLocalNormalUsage {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(() -> {
                String date = new SecondThreadLocalNormalUsage().date(finalI);
                System.out.println(date);

            }).start();
            Thread.sleep(100);
        }
    }

    public String date(int seconds) {
        //参数的单位是毫秒，从1970.1.1 00:00:00 GMT计时
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
