package org.zicheng.stu.collection.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ArrayBlockingQueue实现生产消费模型
 * take 阻塞
 * put 阻塞
 * Author: zicheng
 * Since: 2020-10-11 21:25
 */
public class ProducerConsumerModelTest {
    private static final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);

    private static void execute() {
        // consumer
        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "准备消费...");
                try {
                    Integer value = queue.take();
                    System.out.println(Thread.currentThread().getName() + "消费了: " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        // producer
        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "准备生产...");
                try {
                    Thread.sleep(1000L);
                    Integer value = 0;
                    queue.put(value);
                    System.out.println(Thread.currentThread().getName() + "生产了: " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        ProducerConsumerModelTest.execute();
    }
}
