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

/**
 * 抽象工厂角色
 */
abstract class IpadFactory {
    public abstract Ipad create();
}

/**
 * 具体工厂角色
 */
class IpadProFactory extends IpadFactory {

    @Override
    public Ipad create() {
        return new IpadPro();
    }
}

/**
 * 具体工厂角色
 */
class IpadAirFactory extends IpadFactory {

    @Override
    public Ipad create() {
        return new IpadAir4();
    }
}

/**
 * 具体工厂角色
 */
class IpadMiniFactory extends IpadFactory {

    @Override
    public Ipad create() {
        return new IpadMini();
    }
}

/**
 * 抽象产品角色
 */
class Ipad {
    public Ipad() {
    }
}

/**
 * 具体产品角色
 */
class IpadAir4 extends Ipad {
    public IpadAir4() {
        System.out.println("IpadAir4");
    }
}

/**
 * 具体产品角色
 */
class IpadPro extends Ipad {
    public IpadPro() {
        System.out.println("IpadPro");
    }
}

/**
 * 具体产品角色
 */
class IpadMini extends Ipad {
    public IpadMini() {
        System.out.println("IpadMini");
    }
}