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
public interface IConnInfo {
    public boolean loadConnInfo();
    public String getDriverName();
    public String getUrl();
    public String getUser();
    public String getPwd();
}
