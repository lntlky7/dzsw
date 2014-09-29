/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dz.jpa.writer;

import com.dz.jpa.utils.SimpleProxyHandler;

/**
 *
 * @author sz
 */
public class WriterProxyFactory {

    public static IWriter getWriter(String className) throws Exception {
        SimpleProxyHandler<IWriter> handler = new SimpleProxyHandler<IWriter>();
        return handler.getProxy(WriterProxyFactory.class.getClassLoader(), className);
    }
}
