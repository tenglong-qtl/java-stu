package org.zicheng.stu.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类
 * Author: T.L. QIU
 * Date: 2020-11-27 11:16.
 */
public class AtmoicClassTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                atomicInteger.incrementAndGet();
            }
        });
        thread.start();

        for (int i = 0; i < 1000000; i++) {
            atomicInteger.incrementAndGet();
        }

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(atomicInteger.get());


    }
}
