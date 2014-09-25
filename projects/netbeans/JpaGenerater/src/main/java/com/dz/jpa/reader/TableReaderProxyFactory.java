/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.reader;

import com.dz.jpa.utils.SimpleProxyHandler;

/**
 *
 * @author sz
 */
public class TableReaderProxyFactory {

    public static ITableReader getReader(String className) throws Exception {
        SimpleProxyHandler<ITableReader> handler = new SimpleProxyHandler<ITableReader>();
        return handler.getProxy(TableReaderProxyFactory.class.getClassLoader(), className);
    }
}
