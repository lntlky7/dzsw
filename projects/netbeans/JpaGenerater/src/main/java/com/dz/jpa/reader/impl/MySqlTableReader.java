/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.reader.impl;

import com.dz.jpa.bean.table.PrimaryKey;
import com.dz.jpa.bean.table.Table;
import java.sql.ResultSet;
import com.dz.jpa.db.JdbcDb;
import com.dz.jpa.reader.IColumnReader;
import com.dz.jpa.reader.IFKReader;
import com.dz.jpa.reader.IPKReader;
import com.dz.jpa.reader.ITableReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sz
 */
public class MySqlTableReader implements ITableReader {

    @Override
    public Map<String, Table> readTable() throws Exception {
        Map<String, Table> map = new HashMap<String, Table>();
        Connection conn = JdbcDb.getInstance().getConn();
        DatabaseMetaData metaData = conn.getMetaData();
        String schema = JdbcDb.getInstance().getSchema();
        String tableNamePattern = JdbcDb.getInstance().getTableNamePattern();
        // 查询数据库下所有表
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            String sqlTables = "SELECT TABLE_NAME,TABLE_COMMENT FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = ?";
            pstmt = conn.prepareStatement(sqlTables);
            pstmt.setString(1, "bluedb");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Table t = new Table();
                t.setTableName(rs.getString("TABLE_NAME").toUpperCase());
                t.setComment(rs.getString("TABLE_COMMENT"));
                map.put(t.getTableName(), t);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        }
        rs = metaData.getTables(conn.getCatalog(), schema, tableNamePattern, new String[]{"TABLE"});
        while (rs.next()) {
            Table t = map.get(rs.getString("TABLE_NAME").toUpperCase());
//            Table t = new Table();
//            t.setTableName(rs.getString("TABLE_NAME").toUpperCase());
//            t.setComment(rs.getString("REMARKS"));
            // read column
            IColumnReader columnReader = new MySqlColumnReader();
            t.setColumnMap(columnReader.readTableColumn(schema, t.getTableName()));
            // read pk
            IPKReader pkReader = new MySqlPKReader();
            Map<String, PrimaryKey> pkMap = pkReader.readTablePK(schema, t.getTableName());
            if (pkMap == null) {
                System.out.println(t.getTableName());
            }
            t.setPrimaryKeyMap(pkMap);
            // read fk
            IFKReader fkReader = new MySqlFKReader();
            t.setForeignKeyMap(fkReader.readTableFK(schema, t.getTableName()));
            // is mid table
            if (t.getColumnMap().size() == 2 && t.getForeignKeyMap().size() == 2) {
                t.setMidTable(true);
            } else {
                t.setMidTable(false);
            }
            //map.put(t.getTableName(), t);
        }
        return map;
    }

}
