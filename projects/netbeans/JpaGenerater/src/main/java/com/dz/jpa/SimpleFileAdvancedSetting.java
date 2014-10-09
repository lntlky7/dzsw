/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author sz
 */
public class SimpleFileAdvancedSetting implements IAdvancedSetting{

    private String moduleName;

    @Override
    public void loadSetting() throws Exception {
        String settingFile = new File(this.getClass().getResource("/").toURI()).getPath() + "\\advanced_setting.properties";
        Properties p = new Properties();
        p.load(new FileInputStream(new File(settingFile)));

        this.moduleName = p.getProperty("adv_setting.modulename");
    }
    
    @Override
    public String getModuleName() {
        return this.moduleName;
    }

}
