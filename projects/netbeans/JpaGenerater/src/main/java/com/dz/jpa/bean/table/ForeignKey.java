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
    private String masterTable;
    private String fkName;
    private String slaveTable;

    public String getPkName() {
        return pkName;
    }

    public void setPkName(String pkName) {
        this.pkName = pkName;
    }

    public String getFkName() {
        return fkName;
    }

    public void setFkName(String fkName) {
        this.fkName = fkName;
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
