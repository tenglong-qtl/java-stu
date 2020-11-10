package org.zicheng.stu.designpattern.factory;

/**
 * 简单工厂模式
 * Author: T.L. QIU
 * Date: 2020-11-10 17:54.
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        Huawei p30 = HuaweiFactory.create(30);
        Huawei p40 = HuaweiFactory.create(40);
    }
}

class HuaweiFactory {
    public static Huawei create(int type) {
        if (type == 30) {
            return new HuaweiP30();
        } else if (type == 40) {
            return new HuaweiP40Pro();
        } else if (type == 20) {
            return new HuaweiP20();
        }
        return null;
    }
}

class Huawei {
    public Huawei() {
    }
}

class HuaweiP30 extends Huawei {
    public HuaweiP30() {
        System.out.println("HuaweiP30");
    }
}

class HuaweiP20 extends Huawei {
    public HuaweiP20() {
        System.out.println("HuaweiP20");
    }
}

class HuaweiP40Pro extends Huawei {
    public HuaweiP40Pro() {
        System.out.println("HuaweiP40Pro");
    }
}