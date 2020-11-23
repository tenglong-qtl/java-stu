package org.zicheng.stu;

/**
 * Author: T.L. QIU
 * Date: 2020-11-13 9:59.
 */
public class Test {
    private static final Test instance = new Test();

    private Test() {
    }

    public static Test getInstance() {
        return instance;
    }
}
