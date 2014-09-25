/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author sz
 * @param <T>
 */
public abstract class AbstractProxyHandler<T> implements InvocationHandler {

    protected T proxyInstance;

    public T getProxy(ClassLoader loader, String className) throws Exception {
        Class clazz = loader.loadClass(className);
        proxyInstance = (T) clazz.newInstance();
        return (T) Proxy.newProxyInstance(loader, clazz.getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = null;
        try {
            this.before();
            ret = method.invoke(proxyInstance, args);
            this.after();
        } catch (Throwable e) {
            this.error(e);
            throw e;
        } finally {
            this.forever();
        }
        return ret;
    }

    public abstract void before();

    public abstract void after();
    
    public abstract void error(Throwable e);
    
    public abstract void forever();
}
