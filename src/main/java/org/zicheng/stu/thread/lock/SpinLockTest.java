package org.zicheng.stu.thread.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自制自旋锁
 * Author: T.L. QIU
 * Date: 2020-11-25 10:58.
 */
public class SpinLockTest {

    private final AtomicReference<Thread> owner = new AtomicReference<>();
    private int reentrantCount = 0;

    public void lock() {
        Thread t = Thread.currentThread();
        if (t == owner.get()) {
            ++reentrantCount;
            return;
        }
        do {
            System.out.println(t.getName() + "自旋了");
        } while (!owner.compareAndSet(null, t));
    }

    public void unLock() throws IllegalAccessException {
        Thread t = Thread.currentThread();
        if (t != owner.get())
            throw new IllegalAccessException("Access error");
        --reentrantCount;
        if (reentrantCount <= 0) {
            owner.set(null);
            reentrantCount = 0;
        }
    }

    public static void main(String[] args) {

        SpinLockTest spinLock = new SpinLockTest();
        Runnable runnable = () -> {
            Thread thread = Thread.currentThread();
            spinLock.lock();
            System.out.println(thread.getName() + "拿到锁了");
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                spinLock.unLock();
                System.out.println(thread.getName() + "释放锁了");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

}
