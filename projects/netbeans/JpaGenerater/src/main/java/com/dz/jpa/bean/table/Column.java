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
public class Column {

    private String name;
    private int type;
    private String typeName;
    private int length;
    private int decimalDigits;
    private String remark;
    private String defaultValue;

//    private boolean pk;
//    private boolean fk;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(int decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

//    public boolean isPk() {
//        return pk;
//    }
//
//    public void setPk(boolean pk) {
//        this.pk = pk;
//    }
//
//    public boolean isFk() {
//        return fk;
//    }
//
//    public void setFk(boolean fk) {
//        this.fk = fk;
//    }

}
