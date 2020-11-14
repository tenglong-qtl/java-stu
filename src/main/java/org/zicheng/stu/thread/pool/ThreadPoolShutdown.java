package org.zicheng.stu.thread.pool;

import java.util.concurrent.*;

/**
 * Author: zicheng
 * Since: 2020-11-14 21:12
 * Description:
 */
public class ThreadPoolShutdown {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1, 1, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

//        ThreadPoolExecutor executor = new ThreadPoolExecutor(
//                1, 1, 60L, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<Runnable>(1),
//                new RejectedExecutionHandler() {
//                    @Override
//                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//                        System.out.println("拒绝了 " + executor.getPoolSize());
//                    }
//                }
//        );

        /*
          提交了2个任务之后，线程池满了，此时
          第3个任务执行了拒绝策略，CallerRunsPolicy，由提交的线程去执行
         */
        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        executor.shutdown();
        /*
          关闭线程池之后，也会执行拒绝策略，但不会再去执行任务了
         */
        executor.submit(() -> {
            System.out.println("----------" + Thread.currentThread().getName());
        });

    }
}
