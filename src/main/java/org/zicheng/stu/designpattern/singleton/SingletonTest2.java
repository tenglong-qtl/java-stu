package org.zicheng.stu.designpattern.singleton;

/**
 * 懒汉模式 - 	Effective Java推荐写法
 * Author: T.L. QIU
 * Date: 2020-11-11 10:49.
 */
public class SingletonTest2 {

    private SingletonTest2() {

    }

    /**
     * 解决线程安全问题
     * 延迟初始化
     */
    public static SingletonTest2 getInstance() {
        return Holder.instance;
    }

    /**
     * 在私有内部类中类加载期间完成初始化
     */
    private static class Holder {
        private static final SingletonTest2 instance = new SingletonTest2();
    }
}
