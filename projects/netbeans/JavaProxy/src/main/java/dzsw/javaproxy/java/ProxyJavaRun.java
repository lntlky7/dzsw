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
public class ProxyJavaRun {

    public void run() throws Exception {
        String sayHello = "dzsw.javaproxy.SayHello";
        String sayGoHome = "dzsw.javaproxy.SayGoHome";
        ISay say = SayProxyFactory.getSay(sayHello);
        System.out.println(say.say("java proxy"));

        say = SayProxyFactory.getSay(sayGoHome);
        System.out.println(say.say("java proxy"));
    }
}
