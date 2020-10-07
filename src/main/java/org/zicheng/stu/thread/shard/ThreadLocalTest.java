package org.zicheng.stu.thread.shard;

/**
 * Author: zicheng
 * Since: 2020-10-07 22:12
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void test(){
        threadLocal.set(Thread.currentThread().getName());
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() +
                    ": " +
                    threadLocal.get());
        }).start();

        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() +
                ": " +
                threadLocal.get());

        System.out.println(Thread.currentThread().getName() +
                ": " +
                threadLocal.get());

    }

    public static void main(String[] args) {
        ThreadLocalTest.test();
    }

}
