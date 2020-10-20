package com.lgl.juc.threadpool;

/**
 * <p>
 * description
 * </p>
 *
 * @author lgl 2020/10/19 13:33
 * @since 1.0
 */
public class EveryTaskOneThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("执行了任务"));
        thread.start();
    }

}
