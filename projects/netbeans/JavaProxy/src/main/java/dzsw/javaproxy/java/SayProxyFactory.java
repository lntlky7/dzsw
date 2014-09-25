/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dzsw.javaproxy.java;

import dzsw.javaproxy.ISay;

/**
 *
 * @author sz
 */
public class SayProxyFactory {

    public static ISay getSay(String className) throws Exception {
        SayHandler<ISay> handler = new SayHandler<ISay>();
        return handler.getProxy(SayProxyFactory.class.getClassLoader(), className);
    }
}
