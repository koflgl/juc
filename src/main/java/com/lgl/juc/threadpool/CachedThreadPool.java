package com.lgl.juc.threadpool;

import java.util.concurrent.*;

/**
 * <p>
 * description
 * </p>
 *
 * @author lgl 2020/10/19 10:21
 * @since 1.0
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<1000;i++){
            executorService.execute(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}



