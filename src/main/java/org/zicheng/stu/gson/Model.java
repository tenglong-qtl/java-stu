package org.zicheng.stu.gson;

/**
 * Author: T.L. QIU
 * Date: 2020-11-23 15:17.
 */
public class Model {
    private String name;
    private int age;

    public Model(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
