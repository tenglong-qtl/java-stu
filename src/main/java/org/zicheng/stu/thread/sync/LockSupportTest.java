package org.zicheng.stu.thread.sync;

import java.util.concurrent.locks.LockSupport;

/**
 * Author: zicheng
 * Since: 2020-10-07 22:01
 */
public class LockSupportTest {
    private Object object = new Object();

    public static void simple() {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " run1");
            // park 公园 寄存 停放
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + " run2");
        });
        thread.start();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(thread);
    }

    public static void deadLock() {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " run1");
            synchronized (LockSupportTest.class) {
                // park 公园 寄存 停放
                LockSupport.park();
            }
            System.out.println(Thread.currentThread().getName() + " run2");
        });
        thread.start();
        System.out.println(Thread.currentThread().getName() + " run");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (LockSupportTest.class) {
            LockSupport.unpark(thread);
        }
    }

    public static void main(String[] args) {
        LockSupportTest.deadLock();
    }
}
