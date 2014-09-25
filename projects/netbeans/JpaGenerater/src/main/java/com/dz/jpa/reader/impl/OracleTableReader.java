/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.reader.impl;

import com.dz.jpa.bean.table.Table;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.dz.jpa.db.JdbcDb;
import com.dz.jpa.reader.IColumnReader;
import com.dz.jpa.reader.IFKReader;
import com.dz.jpa.reader.IPKReader;
import com.dz.jpa.reader.ITableReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

/**
 *
 * @author sz
 */
public class OracleTableReader implements ITableReader {

    public List<Table> readTable() throws Exception {
        List<Table> list = new ArrayList<Table>();
        Connection conn = JdbcDb.getInstance().getConn();
        DatabaseMetaData metaData = conn.getMetaData();
        String schema = JdbcDb.getInstance().getSchema();
        String tableNamePattern = JdbcDb.getInstance().getTableNamePattern();
        ResultSet rs = metaData.getTables(conn.getCatalog(), schema, tableNamePattern, new String[]{"TABLE"});
        while (rs.next()) {
            Table t = new Table();
            t.setTableName(rs.getString("TABLE_NAME"));
            t.setComment(rs.getString("REMARKS"));
            // read column
            IColumnReader columnReader = new OracleColumnReader();
            t.setColumnMap(columnReader.readTableColumn(t.getTableName()));
            // read pk
            IPKReader pkReader = new OraclePKReader();
            t.setPrimaryKeyMap(pkReader.readTablePK(t.getTableName()));
            // read fk
            IFKReader fkReader = new OracleFKReader();
            t.setForeignKeyMap(fkReader.readTableFK(t.getTableName()));
            list.add(t);
        }
        return list;
    }

}
