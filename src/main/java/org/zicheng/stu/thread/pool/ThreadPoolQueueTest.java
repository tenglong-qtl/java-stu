package org.zicheng.stu.thread.pool;

import java.util.concurrent.*;

/**
 * 测试当线程池满了之后，是否添加任务到消息队列
 * Author: T.L. QIU
 * Date: 2020-10-30 11:37.
 */
public class ThreadPoolQueueTest {
    public static void main(String[] args) {
        BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<Runnable>(5);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 5, 60, TimeUnit.SECONDS,
                taskQueue, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(r + "被拒绝");
                System.out.println(taskQueue.size());
            }
        }
        );

        // 提交10个任务，此时线程池满了，任务队列也满了
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 让任务队列非满
        try {
            System.out.println("queue size: " + taskQueue.size());
            taskQueue.take();
            System.out.println("queue size: " + taskQueue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 此时线程池满了 任务队列未满 提交新任务
        executor.submit(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("提交了： queue size  " + taskQueue.size());

        // 此时线程池满了 任务队列满了 提交新任务
        executor.submit(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


    }
}
