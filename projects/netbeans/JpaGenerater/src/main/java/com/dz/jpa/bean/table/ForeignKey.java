/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.bean.table;

/**
 *
 * @author sz
 */
public class ForeignKey {

    private String pkName;
    private String masterTableName;
    private String fkName;
    private String slaveTableName;

    public String getPkName() {
        return pkName;
    }

    public void setPkName(String pkName) {
        this.pkName = pkName;
    }

    public String getMasterTableName() {
        return masterTableName;
    }

    public void setMasterTableName(String masterTableName) {
        this.masterTableName = masterTableName;
    }

    public String getFkName() {
        return fkName;
    }

    public void setFkName(String fkName) {
        this.fkName = fkName;
    }

    public String getSlaveTableName() {
        return slaveTableName;
    }

    public void setSlaveTableName(String slaveTableName) {
        this.slaveTableName = slaveTableName;
    }

}