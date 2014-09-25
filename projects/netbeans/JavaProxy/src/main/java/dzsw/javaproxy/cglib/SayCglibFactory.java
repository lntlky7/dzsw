/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dzsw.javaproxy.cglib;

import dzsw.javaproxy.ISay;

/**
 *
 * @author sz
 */
public class SayCglibFactory {

    public static ISay getSay(String className) throws Exception {
        SayMethodInterceptor<ISay> interceptor = new SayMethodInterceptor<ISay>();
        return interceptor.getProxy(SayCglibFactory.class.getClassLoader(), className);
    }
}
