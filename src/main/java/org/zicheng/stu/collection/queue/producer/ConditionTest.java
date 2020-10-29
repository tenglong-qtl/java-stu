package org.zicheng.stu.collection.queue.producer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition实现生产者与消费者模式
 * Author: T.L. QIU
 * Date: 2020-10-29 11:30.
 */
public class ConditionTest {
    private Queue<Integer> queue = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition empty = lock.newCondition();
    private Condition full = lock.newCondition();
    private int max = 16;

    public void producer() {
        new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == max) {
                        full.await();
                    }
                    Integer val = new Random().nextInt(10);
                    queue.add(val);
                    empty.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }

    public void consumer() {
        new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        empty.await();
                    }
                    Integer val = queue.poll();
                    System.out.println(val);
                    full.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();
        conditionTest.consumer();
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        conditionTest.producer();
    }
}
