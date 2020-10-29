package org.zicheng.stu.collection.queue.producer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueue实现生产者与消费者
 * ArrayBlockingQueue已经实现了加锁与解锁的逻辑，调用者直接调用即可
 * Author: T.L. QIU
 * Date: 2020-10-29 11:23.
 */
public class BlockingQueueTest {
    private BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1);

    public void producer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Integer val = new Random().nextInt(10);
                    try {
                        blockingQueue.put(val);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void consumer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Integer val = blockingQueue.take();
                        System.out.println(val);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    public static void main(String[] args) {
        BlockingQueueTest queueTest = new BlockingQueueTest();
        queueTest.producer();
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        queueTest.consumer();
    }

}
