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
public class ProxyCglibRun {

    public void run() throws Exception {
        String sayHello = "dzsw.javaproxy.SayHello";
        String sayGoHome = "dzsw.javaproxy.SayGoHome";
        ISay say = SayCglibFactory.getSay(sayHello);
        System.out.println(say.say("cglib"));

        say = SayCglibFactory.getSay(sayGoHome);
        System.out.println(say.say("cglib"));
    }
}
