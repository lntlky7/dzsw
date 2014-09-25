/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dzsw.javaproxy.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author sz
 * @param <T>
 */
public class SayHandler<T> implements InvocationHandler {

    private T proxyInstance;

    public T getProxy(ClassLoader loader, String className) throws Exception {
        Class clazz = loader.loadClass(className);
        proxyInstance = (T) clazz.newInstance();
        return (T) Proxy.newProxyInstance(loader, clazz.getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---before---");
        Object ret = method.invoke(proxyInstance, args);
        System.out.println("---after---");
        return ret;
    }

}
