package org.zicheng.stu;

/**
 * Author: zicheng
 * Since: 2020-11-14 17:22
 * Description:
 */
public class Test {
    public static void main(String[] args) {

        for (int i = 0; i < 100000000; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " created");
                try {
                    Thread.sleep(10000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
