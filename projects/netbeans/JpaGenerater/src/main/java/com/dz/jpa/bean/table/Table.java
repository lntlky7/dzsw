/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.bean.table;

import java.util.Map;

/**
 *
 * @author sz
 */
public class Table {

    private Map<String, PrimaryKey> primaryKeyMap;

    private Map<String, ForeignKey> foreignKeyMap;

    private Map<String, Column> columnMap;

    private String tableName;

    private String comment;

    public Map<String, PrimaryKey> getPrimaryKeyMap() {
        return primaryKeyMap;
    }

    public void setPrimaryKeyMap(Map<String, PrimaryKey> primaryKeyMap) {
        this.primaryKeyMap = primaryKeyMap;
    }

    public Map<String, ForeignKey> getForeignKeyMap() {
        return foreignKeyMap;
    }

    public void setForeignKeyMap(Map<String, ForeignKey> foreignKeyMap) {
        this.foreignKeyMap = foreignKeyMap;
    }

    public Map<String, Column> getColumnMap() {
        return columnMap;
    }

    public void setColumnMap(Map<String, Column> columnMap) {
        this.columnMap = columnMap;
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
