/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dzsw.javaproxy;

/**
 *
 * @author sz
 */
public class SayGoHome implements ISay {

    public String say(String n) {
        String ret = "Go home, " + n;
        System.out.println(this.getClass().getName() + "->" + ret);
        return ret;
    }

}
