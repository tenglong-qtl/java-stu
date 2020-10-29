package org.zicheng.stu.collection.queue.producer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Author: T.L. QIU
 * Date: 2020-10-29 11:47.
 */
public class WaitNotifyTest {
    private Queue<Integer> queue = new LinkedList<>();
    private int max = 16;

    public void producer() {
        new Thread(() -> {
            while (true) {
                try {
                    synchronized (WaitNotifyTest.this) {
                        while (queue.size() == max) {
                            wait();
                        }
                        Integer val = new Random().nextInt(10);
                        queue.add(val);
                        notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void consumer() {
        new Thread(() -> {
            while (true) {
                try {
                    synchronized (WaitNotifyTest.this) {
                        while (queue.size() == 0) {
                            wait();
                        }
                        Integer val = queue.poll();
                        System.out.println(val);
                        notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        WaitNotifyTest waitNotifyTest = new WaitNotifyTest();
        waitNotifyTest.consumer();
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitNotifyTest.producer();
    }

}
