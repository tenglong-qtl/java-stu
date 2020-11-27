package org.zicheng.stu.basis.object;

import java.lang.reflect.Field;

/**
 * Author: T.L. QIU
 * Date: 2020-11-27 16:27.
 */
public class BeanUtils {

    public static void convertor(Object originObj, Object targetObj) throws IllegalAccessException {
        Class originClass = originObj.getClass();
        Class targetClass = targetObj.getClass();

        Field[] originFields = originClass.getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();

        for (Field field : targetFields) {
            for (Field originF : originFields) {
                if (field.getName().equals(originF.getName())) {
                    field.setAccessible(true);
                    originF.setAccessible(true);
                    field.set(targetObj, originF.get(originObj));
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        User user = new User(1001L, "Test");
        UserDTO userDTO = new UserDTO();
        try {
            BeanUtils.convertor(user,userDTO);
            System.out.println(userDTO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
