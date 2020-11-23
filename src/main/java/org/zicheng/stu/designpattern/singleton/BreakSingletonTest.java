package org.zicheng.stu.designpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例模式的破坏
 * Author: T.L. QIU
 * Date: 2020-11-13 9:19.
 */
public class BreakSingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<SingletonObject> clazz = SingletonObject.class;
        Constructor<SingletonObject> c = clazz.getDeclaredConstructor(null);
        c.setAccessible(true);

        SingletonObject object1 = c.newInstance();
        SingletonObject object2 = c.newInstance();

        System.out.println(object1 == object2); // false
    }
}

/**
 * 单例
 */
class SingletonObject {

    private SingletonObject() {
        if (Holder.instance != null) {
            throw new RuntimeException();
        }
    }

    public static SingletonObject getInstance() {
        return Holder.instance;
    }

    private static class Holder {
        private static final SingletonObject instance = new SingletonObject();
    }
}


