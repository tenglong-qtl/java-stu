package org.zicheng.stu.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * Author: zicheng
 * Since: 2020-11-14 07:55
 * Description:
 */
public class DynamicProxy {
    public static void main(String[] args) {
        // 创建真实角色
        IDynamicSubject realSubject = new DynamicRealSubject();
        // 创建动态代理角色
        DynamicPeojectHandler handler = new DynamicPeojectHandler(realSubject);
        // 得到真实角色的类加载器
        ClassLoader classLoader = realSubject.getClass().getClassLoader();

        IDynamicSubject subject = (IDynamicSubject) Proxy.newProxyInstance(
                classLoader,
                new Class[]{IDynamicSubject.class},
                handler
        );
        subject.request();
    }
}

interface IDynamicSubject {
    void request();
}

class DynamicRealSubject implements IDynamicSubject {

    @Override
    public void request() {
        System.out.println("我是真实角色");
    }
}

class DynamicPeojectHandler implements InvocationHandler {
    private Object object;

    public DynamicPeojectHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        preRequest();
        Object result = method.invoke(object, args);
        postRequest();
        return result;
    }

    private void preRequest() {
        System.out.println("preRequest");
    }

    private void postRequest() {
        System.out.println("postRequest");
    }
}