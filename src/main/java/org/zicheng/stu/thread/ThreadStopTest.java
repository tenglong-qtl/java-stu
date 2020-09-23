package org.zicheng.stu.thread;

import java.io.*;

/**
 * 线程停止
 * stop已经被弃用了
 * 中断跟直接停止是不同的
 * Author: T.L. QIU
 * Date: 2020-09-23 14:04.
 */
public class ThreadStopTest {

    public static void testStopThreadForce() {
        new Thread(() -> {
            OutputStream os = null;
            try {
                os = new FileOutputStream(new File("F:\\tmp\\test.txt"));
                os.write("Test".getBytes());
                Thread.currentThread().stop(); // 先执行finally再执行stop
                System.out.println("stop thread");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (null != os) {
                    try {
                        os.close();
                        System.out.println("close stream");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // output: close stream
    }

    public static void testStopThreadForce2() throws InterruptedException {
        Thread thread = new Thread(() -> {
            OutputStream os = null;
            try {
                os = new FileOutputStream(new File("F:\\tmp\\test2.txt"));
                os.write("Test2".getBytes());
                Thread.sleep(3000L);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (null != os) {
                    try {
                        os.close();
                        System.out.println("close stream");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        Thread.sleep(1000L);
        thread.stop();
        System.out.println("stop");

        // output: stop  thread
        // output: close stream
    }

    public static void testStopThreadForce3() throws InterruptedException {
        Thread thread = new Thread(() -> {
            OutputStream os = null;
            try {
                os = new FileOutputStream(new File("F:\\tmp\\test3.txt"));
                os.write("Test3".getBytes());
                Thread.sleep(3000L);
                os.close();
                System.out.println("close stream");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread.sleep(1000L);
        thread.stop();
        System.out.println("stop");

        // output: stop  thread
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadStopTest.testStopThreadForce();

    }

}
