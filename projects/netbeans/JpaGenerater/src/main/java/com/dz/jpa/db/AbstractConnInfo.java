/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.db;

/**
 *
 * @author Administrator
 */
public abstract class AbstractConnInfo implements IConnInfo {

    protected String driverName;

    protected String url;

    protected String user;

    protected String pwd;

    protected boolean init() {
        boolean result = true;
        try {
            this.setValues();
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        }
        return result;
    }

    public boolean loadConnInfo() {
        return this.init();
    }

    protected abstract void setValues() throws Exception;

    public String getDriverName() {
        return this.driverName;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUser() {
        return this.user;
    }

    public String getPwd() {
        return this.pwd;
    }

    protected boolean isInited() {
        boolean result = false;
        if ((driverName != null && !"".equals(driverName))
                && (url != null && !"".equals(url))
                && (user != null && !"".equals(user))
                && (pwd != null && !"".equals(pwd))) {
            result = true;
        }
        return result;
    }
}
