package org.zicheng.stu.thread.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁 - 读写锁的锁降级
 * Author: T.L. QIU
 * Date: 2020-11-25 9:54.
 */
public class ReadWriteLockTest {
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private boolean needUpdate = true;
    private Object data;

    public void updateCache() {
        readWriteLock.readLock().lock();
        if (needUpdate) {
            readWriteLock.readLock().unlock();
            readWriteLock.writeLock().lock();
            if (needUpdate) {
                data = new Object();
                needUpdate = false;
            }
            readWriteLock.readLock().lock();
            readWriteLock.writeLock().unlock();
        }

        System.out.println(data);
        readWriteLock.readLock().unlock();

    }

    /**
     * 不支持锁升级
     */
    public void lockUpdate() {
        readWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + "得到读锁");
        readWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + "得到写锁");
    }

    public static void main(String[] args) {
        ReadWriteLockTest lockTest = new ReadWriteLockTest();
//        lockTest.updateCache();
        lockTest.lockUpdate();
    }
}
