/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sf.sfjpa.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author Administrator
 */
public class OracleConnInfo extends AbstractConnInfo {

    public OracleConnInfo() {

    }

    @Override
    protected void setValues() throws Exception {
        String jdbcPropPath = System.getProperty("user.dir") + "oracle.properties";
        Properties p = new Properties();
        p.load(new FileInputStream(new File(jdbcPropPath)));
        p.getProperty(url);
        this.driverName = p.getProperty("jdbc.driverClass");
        this.url = p.getProperty("jdbc.jdbcUrl");
        this.user = p.getProperty("jdbc.username");
        this.pwd = p.getProperty("jdbc.password");
    }
    
}
