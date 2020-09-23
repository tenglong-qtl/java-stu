package org.zicheng.stu.thread;

/**
 * Java线程状态
 * Author: T.L. QIU
 * Date: 2020-09-23 12:03.
 */
public class ThreadStatusTest {

    public static void testStatusNEW(){
        System.out.println(new Thread(() -> {

        }).getState());
    }

    public static void main(String[] args) {
        // NEW
        ThreadStatusTest.testStatusNEW();
    }
}
