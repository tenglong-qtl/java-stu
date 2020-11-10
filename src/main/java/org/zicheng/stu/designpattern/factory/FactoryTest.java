package org.zicheng.stu.designpattern.factory;

/**
 * 工厂模式
 * Author: T.L. QIU
 * Date: 2020-11-10 18:00.
 */
public class FactoryTest {
    public static void main(String[] args) {
        IpadFactory proFactory = new IpadProFactory();
        Ipad ipadPro = proFactory.create();

        IpadFactory airFactory = new IpadAirFactory();
        Ipad ipadAir = airFactory.create();
    }
}

abstract class IpadFactory {
    public abstract Ipad create();
}

class IpadProFactory extends IpadFactory {

    @Override
    public Ipad create() {
        return new IpadPro();
    }
}

class IpadAirFactory extends IpadFactory {

    @Override
    public Ipad create() {
        return new IpadAir4();
    }
}

class IpadMiniFactory extends IpadFactory {

    @Override
    public Ipad create() {
        return new IpadMini();
    }
}


class Ipad {
    public Ipad() {
    }
}

class IpadAir4 extends Ipad {
    public IpadAir4() {
        System.out.println("IpadAir4");
    }
}

class IpadPro extends Ipad {
    public IpadPro() {
        System.out.println("IpadPro");
    }
}

class IpadMini extends Ipad {
    public IpadMini() {
        System.out.println("IpadMini");
    }
}