/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.bean.entity;

/**
 *
 * @author sz
 */
public class EntityMapping {

    private Properties prop;

    private int mappingType;

    private String masterClass;

    private String slaveClass;

    private String masterTable;

    private String slaveTable;

    private String joinColumns;

    private String midTabel;

    private String inverseJoinColumns;

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public int getMappingType() {
        return mappingType;
    }

    public void setMappingType(int mappingType) {
        this.mappingType = mappingType;
    }

    public String getJoinColumns() {
        return joinColumns;
    }

    public void setJoinColumns(String joinColumns) {
        this.joinColumns = joinColumns;
    }

    public String getMidTabel() {
        return midTabel;
    }

    public void setMidTabel(String midTabel) {
        this.midTabel = midTabel;
    }

    public String getInverseJoinColumns() {
        return inverseJoinColumns;
    }

    public void setInverseJoinColumns(String inverseJoinColumns) {
        this.inverseJoinColumns = inverseJoinColumns;
    }

    public String getMasterClass() {
        return masterClass;
    }

    public void setMasterClass(String masterClass) {
        this.masterClass = masterClass;
    }

    public String getSlaveClass() {
        return slaveClass;
    }

    public void setSlaveClass(String slaveClass) {
        this.slaveClass = slaveClass;
    }

    public String getMasterTable() {
        return masterTable;
    }

    public void setMasterTable(String masterTable) {
        this.masterTable = masterTable;
    }

    public String getSlaveTable() {
        return slaveTable;
    }

    public void setSlaveTable(String slaveTable) {
        this.slaveTable = slaveTable;
    }

}
