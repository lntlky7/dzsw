/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.transform;

import com.dz.jpa.utils.SimpleProxyHandler;

/**
 *
 * @author sz
 */
public class DialectProxyFactory {

    public static IDialect getDialect(String className) throws Exception {
        SimpleProxyHandler<IDialect> handler = new SimpleProxyHandler<IDialect>();
        return handler.getProxy(DialectProxyFactory.class.getClassLoader(), className);
    }
}
