package org.zicheng.stu.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock接口方法
 * Author: zicheng
 * Since: 2020-11-21 14:44
 * Description:
 */
public class LockTest {
    private Lock myLock = new ReentrantLock();

    public void testLock() {
        try {
            myLock.lock();
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // ...
        } finally {
            myLock.unlock();
        }
    }

    public void testTryLock() {

        if (myLock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + "拿到锁了");
            } finally {
                myLock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "拿不到锁了");
        }
    }

    public void testTryLockWait() {
        try {
            if (myLock.tryLock(2L, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + " Get 到锁了");
                    Thread.sleep(3000L);
                } finally {
                    myLock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "竞争了2S还是竞争不到锁");
            }
        } catch (InterruptedException e) {
            System.out.println("竞争锁时间段内被中断了，取消继续竞争");
        }
    }

    public void testLockInterruptibly() {
        try {
            myLock.lockInterruptibly();
            try {
                System.out.println(Thread.currentThread().getName() + "冲冲冲");
            } finally {
                myLock.unlock();
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "竞争锁中途被中断了");
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
//        new Thread(() -> {
//            lockTest.testLock();
////            lockTest.testTryLock();
////            lockTest.testTryLockWait();
////            lockTest.testLockInterruptibly();
//        }).start();
        lockTest.testTryLockWait();
    }

}
