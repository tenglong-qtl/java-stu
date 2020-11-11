package org.zicheng.stu.designpattern.singleton;

/**
 * 饿汉模式
 * Author: T.L. QIU
 * Date: 2020-11-11 10:39.
 */
public class SingletonTest1 {
    /**
     * 类加载期间完成初始化 没有线程安全
     *
     * 类加载时提前初始化，延长了类加载时间
     * 初始化不能传递参数
     */
    private static final SingletonTest1 instance = new SingletonTest1();

    /**
     * 避免外部调用构造方法
     * 收口
     */
    private SingletonTest1(){

    }

    public static SingletonTest1 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingletonTest1 inst = SingletonTest1.getInstance();
        SingletonTest1 inst2 = SingletonTest1.getInstance();
        System.out.println(inst == inst2); // true
    }
}
