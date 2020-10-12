package org.zicheng.stu.collection.queue;

import javax.jnlp.IntegrationService;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Author: zicheng
 * Since: 2020-10-12 23:18
 */
public class ArrayBockingQueueTest {
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    // 抛出异常
    public void testAdd(){
        for (int i = 0; i < 11; i++) {
            queue.add(i);
        }
    }

    // 返回true or false
    public void testOffer(){
        for (int i = 0; i < 11; i++) {
            System.out.println(queue.offer(i));
        }
    }

    // 阻塞
    public void testPut(){
        for (int i = 0; i < 11; i++) {
            try {
                queue.put(i);
                System.out.println("put done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    // 等待一段时间后返回
    public void testOfforTime(){
        for (int i = 0; i < 11; i++) {
            try {
                System.out.println(queue.offer(i,500L, TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ArrayBockingQueueTest test = new ArrayBockingQueueTest();
        test.testOfforTime();
    }
}
