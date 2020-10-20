package com.lgl.juc.threadlocal;

/**
 * <p>
 * description
 * </p>
 *
 * @author lgl 2020/10/20 20:04
 * @since 1.0
 */
public class ThreadLocalNPE {

    ThreadLocal<Long> longThreadLocal = new ThreadLocal<Long>();

    public void set() {
        longThreadLocal.set(Thread.currentThread().getId());
    }

    //定义得时Long类型的，返回long时会进行拆箱报空指针
    public long get() {
        return longThreadLocal.get();
    }

    public static void main(String[] args) {
        ThreadLocalNPE threadLocalNPE = new ThreadLocalNPE();
        System.out.println(threadLocalNPE.get());
        Thread thread1 = new Thread(() -> {
            threadLocalNPE.set();
            System.out.println(threadLocalNPE.get());
        });
        thread1.start();
    }
}
