package dzsw.javaproxy;

import dzsw.javaproxy.cglib.ProxyCglibRun;
import dzsw.javaproxy.java.ProxyJavaRun;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws Exception {
        ProxyJavaRun javaRun = new ProxyJavaRun();
        javaRun.run();
        
        System.out.println("==============================================================");
        
        ProxyCglibRun cglibRun = new ProxyCglibRun();
        cglibRun.run();
    }
}
