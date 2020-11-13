package org.zicheng.stu.designpattern.proxy;

/**
 * 静态代理
 * Author: zicheng
 * Since: 2020-11-13 23:17
 * Description:
 */
public class StaticProxy {
    public static void main(String[] args) {
        ISubject subject = new ProxySubject();
        subject.request();
    }
}

/**
 * 代理角色和真实角色都继承或实现同一个接口
 */
interface ISubject {
    void request();
}

class RealSubject implements ISubject {

    @Override
    public void request() {
        System.out.println("被代理的对象");
    }
}

/**
 * 代理角色持有真实角色的引用
 */
class ProxySubject implements ISubject {
    private ISubject realSubject = null;

    /**
     * 进行一系列附加操作
     */
    @Override
    public void request() {
        preRequest();
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        realSubject.request();

        postRequest();
    }

    private void preRequest() {
        System.out.println("预处理");
    }

    private void postRequest() {
        System.out.println("后续处理");
    }
}