package org.zicheng.stu.thread.lock;

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

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        new Thread(() -> {
            lockTest.testLock();
        }).start();
        lockTest.testLock();
    }

}
