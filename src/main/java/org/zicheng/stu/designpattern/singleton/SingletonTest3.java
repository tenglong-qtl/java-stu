package org.zicheng.stu.designpattern.singleton;

/**
 * 懒汉模式 - 双重校验锁
 * Author: T.L. QIU
 * Date: 2020-11-11 10:53.
 */
public class SingletonTest3 {
    private volatile static SingletonTest3 instance;

    private SingletonTest3() {

    }

    public static SingletonTest3 getInstance() {
        if (instance == null) {
            synchronized (SingletonTest3.class) {
                if (instance == null) {
                    instance = new SingletonTest3();
                }
            }
        }
        return instance;
    }
}
