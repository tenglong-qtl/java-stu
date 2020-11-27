package org.zicheng.stu.basis.object;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Author: zicheng
 * Since: 2020-10-12 00:17
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class<User> clz = User.class;
        Constructor<User> constructor = clz.getConstructor(
                Long.class,
                String.class
        );

        User user = constructor.newInstance(1001L,"userName");

        Field field = clz.getDeclaredField("userName");
        field.setAccessible(true);
        field.get(user);



    }
}
