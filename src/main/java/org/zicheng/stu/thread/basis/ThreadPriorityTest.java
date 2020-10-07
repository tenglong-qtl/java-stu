package org.zicheng.stu.thread.basis;

/**
 * 线程优先级 1~10 default 5
 * 只是参考值 具体优先级由操作系统决定
 * Author: T.L. QIU
 * Date: 2020-09-23 10:49.
 */
public class ThreadPriorityTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " priority: " + Thread.currentThread().getPriority());
        });
        thread.setPriority(10);
        thread.start();

        // output: Thread-0 priority: 10
    }
}
