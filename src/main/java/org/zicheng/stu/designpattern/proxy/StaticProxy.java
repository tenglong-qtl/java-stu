package org.zicheng.stu.designpattern.proxy;

/**
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


interface ISubject {
    void request();
}

class RealSubject implements ISubject {

    @Override
    public void request() {
        System.out.println("被代理的对象");
    }
}


class ProxySubject implements ISubject {
    private ISubject realSubject = null;

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