/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.db;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.util.Properties;

/**
 *
 * @author sz
 */
public class OracleConnInfo extends AbstractConnInfo {

    public OracleConnInfo() {

    }

    @Override
    protected void setValues() throws Exception {
        String jdbcPropPath = new File(this.getClass().getResource("/").toURI()).getPath() + "\\oracle.properties";
        Properties p = new Properties();
        p.load(new FileInputStream(new File(jdbcPropPath)));
        this.driverName = p.getProperty("jdbc.driverClass");
        this.url = p.getProperty("jdbc.jdbcUrl");
        String remarksReporting = p.getProperty("jdbc.oracle.remarksReporting");
        this.props = new Properties();
        props.setProperty("remarksReporting", remarksReporting);
        props.setProperty("user",  p.getProperty("jdbc.username"));
        props.setProperty("password", p.getProperty("jdbc.password"));
    }
    
}
