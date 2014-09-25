/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dzsw.javaproxy.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 *
 * @author sz
 */
public class SayMethodInterceptor<T> implements MethodInterceptor {

    private T cglibInstance;

    public T getProxy(ClassLoader loader, String className) throws Exception {
        cglibInstance = (T) loader.loadClass(className).newInstance();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.cglibInstance.getClass());
        // 回调方法  
        enhancer.setCallback(this);
        // 创建代理对象  
        return (T) enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] os, MethodProxy mp) throws Throwable {
        System.out.println("---before---");
        Object ret = method.invoke(cglibInstance, os);
        System.out.println("---after---");
        return ret;
    }

}
