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
public class StrategyProxyFactory {

    public static ITable2EntityStrategy getStrategy(String className) throws Exception {
        SimpleProxyHandler<ITable2EntityStrategy> handler = new SimpleProxyHandler<ITable2EntityStrategy>();
        return handler.getProxy(StrategyProxyFactory.class.getClassLoader(), className);
    }
}
