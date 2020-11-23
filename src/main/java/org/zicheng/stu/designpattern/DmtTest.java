package org.zicheng.stu.designpattern;

/**
 * 多个组合少用继承：
 * 方法容易被重写后改变
 * 容易继承到不需要的方法
 * Author: zicheng
 * Since: 2020-11-14 15:04
 * Description:
 */
public class DmtTest {
    public static void main(String[] args) {
        B b = new B();
        // 本来是a-b 被继承后修改了
        b.func1();
        b.func2();
    }
}

class A {
    public void func1() {
        System.out.println("a - b");
    }
}

class B extends A {
    @Override
    public void func1() {
        System.out.println("a + b");
    }

    public void func2() {
        System.out.println("a + b + 100");
    }
}
