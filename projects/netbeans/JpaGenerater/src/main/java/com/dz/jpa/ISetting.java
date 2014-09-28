/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa;

/**
 *
 * @author sz
 */
public interface ISetting {

    public void loadSetting() throws Exception;

    public String getWriter();

    public String getReader();

    public String getStrategy();

    public String getDialect();
    
    public String getOutPath();
    
    public String getPackage();
}
