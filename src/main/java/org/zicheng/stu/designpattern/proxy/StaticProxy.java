package org.zicheng.stu.designpattern.proxy;

/**
 * 静态代理
 * 在不改动现有类的基础上，需要拓展其功能。可以为现有类
 * 创建一个代理对象，两者都实现同一个接口，代理类中持有
 * 被代理者的引用，同时做一些拓展，外部调用只需使用代理类即可。
 * 这样就做到，不改变现有类的基础上，修改与拓展
 * <p>
 * 缺点：
 * 代理角色和真实角色都实现同一个接口，当接口发生变化时，代理角色也需要做修改
 * 100个真实角色，就需要为其创建100个代理角色，难以维护
 * Author: zicheng
 * Since: 2020-11-13 23:17
 * Description:
 */
public class StaticProxy {
    public static void main(String[] args) {
        ISubject subject = new ProxySubject(new RealSubject());
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
     * 该代理角色是为ISubject接口创建的，
     * 所有实现该接口的真实角色都可使用
     * 当其他接口也需要实现这些拓展时，由需要为其他接口创建代理角色类
     */
    public ProxySubject(ISubject subject) {
        this.realSubject = subject;
    }

    /**
     * 进行一系列附加操作
     */
    @Override
    public void request() {
        preRequest();

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