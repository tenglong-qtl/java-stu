package org.zicheng.stu.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Author: T.L. QIU
 * Date: 2020-10-30 12:25.
 */
public class ShutDownThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,5 ,60000L , TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));


    }
}
