package org.zicheng.stu.thread;

/**
 * Author: T.L. QIU
 * Date: 2020-09-23 14:40.
 */
public class ThreadInterruptTest {

    public static void testInterrupted(){
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : " + Thread.interrupted());
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " : " + Thread.interrupted());
                System.out.println(Thread.currentThread().getName() + " : " + Thread.interrupted());
            }
        });
        t1.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        // System.out.println(Thread.currentThread().getName() + " : " + Thread.interrupted());

    }

    public static void testInterrupted2(){
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : " + Thread.interrupted());
            Thread.currentThread().interrupt();
            //System.out.println(Thread.currentThread().getName() + " : " + Thread.interrupted());
            //System.out.println(Thread.currentThread().getName() + " : " + Thread.interrupted());
        });
        t1.start();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : " + Thread.interrupted());

    }

    public static void testInterruptWhileSleep() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted()); // output:false
            }
        });
        t1.start();
        Thread.sleep(1000L);
        t1.interrupt();

    }

    public static void testInterruptWhileWait() throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock){
                try {
                    lock.wait(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread.sleep(1000L);
        t1.join();

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadInterruptTest.testInterruptWhileWait();
    }
}
