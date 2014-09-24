/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.bean;

import java.util.List;
import java.util.Map;

/**
 *
 * @author sz
 */
public class Table {

    private Map<String, PrimaryKey> primaryKeyList;

    private Map<String, ForeignKey> foreignKeyList;

    private Map<String, Column> columnList;

    private String tableName;

    private String comment;

    public Map<String, PrimaryKey> getPrimaryKeyList() {
        return primaryKeyList;
    }

    public void setPrimaryKeyList(Map<String, PrimaryKey> primaryKeyList) {
        this.primaryKeyList = primaryKeyList;
    }

    public Map<String, ForeignKey> getForeignKeyList() {
        return foreignKeyList;
    }

    public void setForeignKeyList(Map<String, ForeignKey> foreignKeyList) {
        this.foreignKeyList = foreignKeyList;
    }

    public Map<String, Column> getColumnList() {
        return columnList;
    }

    public void setColumnList(Map<String, Column> columnList) {
        this.columnList = columnList;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
