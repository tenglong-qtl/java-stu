package org.zicheng.stu.thread.lock;

/**
 * Lock remove
 * Author: T.L. QIU
 * Date: 2020-11-25 11:37.
 */
public class LockRemove {

    public synchronized void test() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        LockRemove lockRemove = new LockRemove();
        lockRemove.test(); // single thread run it
    }
}
