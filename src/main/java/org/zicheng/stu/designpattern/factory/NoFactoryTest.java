package org.zicheng.stu.designpattern.factory;

/**
 * 不使用工厂模式
 * Author: T.L. QIU
 * Date: 2020-11-10 17:47.
 */
public class NoFactoryTest {
    public static void main(String[] args) {
        IphoneX iphoneX = new IphoneX();
        Iphone11 iphone11 = new Iphone11();
        Iphone12 iphone12 = new Iphone12();
    }
}

class IphoneX {
    public IphoneX() {
        System.out.println("IphoneX");
    }
}

class Iphone11 {
    public Iphone11() {
        System.out.println("Iphone11");
    }
}

class Iphone12 {
    public Iphone12() {
        System.out.println("Iphone12");
    }
}
