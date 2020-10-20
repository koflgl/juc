package com.lgl.juc.threadlocal;

/**
 * <p>
 * description
 * </p>
 *
 * @author lgl 2020/10/20 20:02
 * @since 1.0
 */
public class SeventhThreadLocalNormalUsage {

    public static void main(String[] args) {
        new Service1().process("");
    }
}

class Service1 {

    public void process(String name) {
        User lgl = new User("lgl");
        UserContextHolder.holder.set(lgl);
        new Service2().process();
    }
}

class Service2 {

    public void process() {
        User user = UserContextHolder.holder.get();
        ThreadSafeFormatter.dateFormatThreadLocal.get();
        System.out.println("Service2拿到用户名：" + user.name);
        new Service3().process();
    }
}

class Service3 {

    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service3拿到用户名：" + user.name);
        UserContextHolder.holder.remove();
    }
}

class UserContextHolder {

    public static ThreadLocal<User> holder = new ThreadLocal<>();

}

class User {

    String name;

    public User(String name) {
        this.name = name;
    }
}
