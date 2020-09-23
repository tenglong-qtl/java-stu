package org.zicheng.stu.thread;

/**
 * ThreadGroup
 * 默认使用父线程的线程组
 * Thread.currentThread().getThreadGroup()
 * Author: T.L. QIU
 * Date: 2020-09-23 10:45.
 */
public class ThreadGroupTest {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getThreadGroup().getName());
        }).start();
        System.out.println(Thread.currentThread().getThreadGroup().getName());

        // output : main
        // output : main
    }
}
