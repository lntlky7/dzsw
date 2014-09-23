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
public class JdbcProp {

    static class JdbcPropHolder {

        public static JdbcProp instance = new JdbcProp();
    }

    public static JdbcProp getInstance() {
        return JdbcPropHolder.instance;
    }
    private String driverName;
    private String url;
    private String userName;
    private String userPwd;

    public void init() throws Exception {
        if (!isInited()) {
            readJdbcProp();
        }
    }

    public void readJdbcProp() throws Exception {
        String jdbcPropPath = System.getProperty("user.dir") + "\\jdbc.properties";
        Properties p = new Properties();
        p.load(new FileInputStream(new File(jdbcPropPath)));
        p.getProperty(url);
        this.driverName = p.getProperty("jdbc.driverClass");
        this.url = p.getProperty("jdbc.jdbcUrl");
        this.userName = p.getProperty("jdbc.username");
        this.userPwd = p.getProperty("jdbc.password");
    }

    public boolean isInited() {
        boolean result = false;
        if ((driverName != null && !"".equals(driverName))
                && (url != null && !"".equals(url))
                && (userName != null && !"".equals(userName))
                && (userPwd != null && !"".equals(userPwd))) {
            result = true;
        }
        return result;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

}
