/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author sz
 */
public class JdbcDb {

    private String driverName;
    private String url;
    private Properties props;
//    private String userName;
//    private String userPwd;

    private Connection conn;

    static class JdbcDbHolder {
        public static JdbcDb instance = new JdbcDb();
    }

    public static JdbcDb getInstance() {
        return JdbcDbHolder.instance;
    }

    public JdbcDb() {

    }

    public void init(String driverName, String url, Properties props) {
        this.driverName = driverName;
        this.url = url;
        this.props = props;
    }

    public void openConn() throws Exception {
        Class.forName(this.driverName);
        conn = DriverManager.getConnection(url, props);
    }

    public Connection getConn() {
        return conn;
    }

    public void closeConn() throws Exception {
        if (conn != null) {
            conn.close();
        }
    }

}
