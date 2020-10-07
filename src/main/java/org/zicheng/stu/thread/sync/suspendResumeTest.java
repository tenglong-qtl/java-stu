package org.zicheng.stu.thread.sync;

/**
 * Author: zicheng
 * Since: 2020-10-07 21:42
 */
public class suspendResumeTest {

    public static void simple(){
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " run1");
            Thread.currentThread().suspend();
            System.out.println(Thread.currentThread().getName() + " run2");
        });
        thread.start();

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        thread.resume();
    }

    public static void deadLock(){
        Thread thread = new Thread(() -> {
            synchronized (suspendResumeTest.class){
                System.out.println(Thread.currentThread().getName() + " run1");
                // 不会释放监视器锁
                Thread.currentThread().suspend();
                System.out.println(Thread.currentThread().getName() + " run2");
            }
        });
        thread.start();

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        synchronized (suspendResumeTest.class){
            thread.resume();
        }
    }

    public static void main(String[] args) {
        suspendResumeTest.deadLock();
    }
}
