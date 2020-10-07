package org.zicheng.stu.thread.pool;

import jdk.nashorn.internal.ir.Block;

import java.util.concurrent.*;

/**
 * Author: zicheng
 * Since: 2020-10-07 22:24
 */
public class ThreadPoolExecutorTest {

    /**
     * 简单提交多任务
     */
    public static void submitTasks(ThreadPoolExecutor threadPoolExecutor) throws InterruptedException {
        if (threadPoolExecutor == null) {
            threadPoolExecutor = new ThreadPoolExecutor(
                    5, 8, 10, TimeUnit.MINUTES,
                    new LinkedBlockingQueue<Runnable>()
            );
        }
        for (int i = 0; i < 15; i++) {
            threadPoolExecutor.submit(() -> {
                // System.out.println(Thread.currentThread().getName() + " run");
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // System.out.println(Thread.currentThread().getName() + " stop");
            });
        }
        Thread.sleep(500L);
        System.out.println("1--------------------");
        System.out.println("pool size " + threadPoolExecutor.getPoolSize());
        System.out.println("queue size " + threadPoolExecutor.getQueue().size());
        Thread.sleep(5000L);
        System.out.println("2--------------------");
        System.out.println("pool size " + threadPoolExecutor.getPoolSize());
        System.out.println("queue size " + threadPoolExecutor.getQueue().size());
    }

    /**
     * 无界队列
     */
    public static void useUnboundQueue() {
        // 无界，永远不会创建核心工作线程之外的线程
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3, 10, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()
        );
        try {
            submitTasks(threadPoolExecutor);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPoolExecutor.shutdown();
    }

    /**
     * 核心线程数量5，最大数量8，队列大小3，超出核心线程数量的线程存活时间：5秒， 指定拒绝策略的
     */
    public static void queue3() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5, 8, 5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + ": 被拒绝");
                    }
                }
        );
        try {
            submitTasks(threadPoolExecutor);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutorTest.queue3();
    }
}
