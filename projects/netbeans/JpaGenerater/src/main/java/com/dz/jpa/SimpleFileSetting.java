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
public class SimpleFileSetting implements ISetting {

    private String strategy;
    private String reader;
    private String writer;
    private String dialect;
    private String outPath;
    private String basePackage;
    private String templatesPath;

    @Override
    public void loadSetting() throws Exception {
        String settingFile = new File(this.getClass().getResource("/").toURI()).getPath() + "\\setting.properties";
        Properties p = new Properties();
        p.load(new FileInputStream(new File(settingFile)));

        this.strategy = p.getProperty("setting.strategy");
        this.reader = p.getProperty("setting.reader");
        this.writer = p.getProperty("setting.writer");
        this.dialect = p.getProperty("setting.dialect");
        this.outPath = p.getProperty("setting.outpath");
        this.basePackage = p.getProperty("setting.package");
        this.templatesPath = p.getProperty("setting.templatepath");
    }

    @Override
    public String getWriter() {
        return this.writer;
    }

    @Override
    public String getReader() {
        return this.reader;
    }

    @Override
    public String getStrategy() {
        return this.strategy;
    }

    @Override
    public String getDialect() {
        return this.dialect;
    }

    @Override
    public String getOutPath() {
        return this.outPath;
    }

    @Override
    public String getPackage() {
        return this.basePackage;
    }

    @Override
    public String getTemplatesPath() {
        return this.templatesPath;
    }

}
