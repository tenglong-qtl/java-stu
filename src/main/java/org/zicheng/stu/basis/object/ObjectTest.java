package org.zicheng.stu.basis.object;

import java.util.Objects;

/**
 * Author: zicheng
 * Since: 2020-10-12 00:17
 */
public class ObjectTest {
    public static void main(String[] args) {
        Integer integer = null;
        // null 时抛出
        Objects.requireNonNull(integer);
    }
}
