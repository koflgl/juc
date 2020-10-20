package com.lgl.juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * description
 * </p>
 *
 * @author lgl 2020/10/20 19:41
 * @since 1.0
 */
public class FirstThreadLocalNormalUsage {
    public static void main(String[] args) {
        new Thread(() ->{
            System.out.println(new FirstThreadLocalNormalUsage().date(10));
        }).start();
        new Thread(()->{
            System.out.println(new FirstThreadLocalNormalUsage().date(10470));
        }).start();
    }

    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
