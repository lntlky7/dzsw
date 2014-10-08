/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.reader.impl;

import com.dz.jpa.bean.table.PrimaryKey;
import com.dz.jpa.db.JdbcDb;
import com.dz.jpa.reader.IPKReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sz
 */
public class MySqlPKReader implements IPKReader {
    
    @Override
    public Map<String, PrimaryKey> readTablePK(String tableName) throws Exception {
        Map<String, PrimaryKey> pkMap = new HashMap<String, PrimaryKey>();
        DatabaseMetaData metaData = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = JdbcDb.getInstance().getConn();
            metaData = conn.getMetaData();
            rs = metaData.getPrimaryKeys(null, null, tableName);
            while (rs.next()) {
                PrimaryKey pk = new PrimaryKey();
                pk.setMasterTable(rs.getString("TABLE_NAME"));
                pk.setPkName(rs.getString("COLUMN_NAME"));
                pk.setSort(rs.getInt("KEY_SEQ"));
                pkMap.put(pk.getPkName(), pk);
            }
            rs.close();
            rs = metaData.getExportedKeys(null, null, tableName);
            while (rs.next()) {
                String pkName = rs.getString("PKCOLUMN_NAME");
                PrimaryKey pk = pkMap.get(pkName);
                pk.setSlaveTable(rs.getString("FKTABLE_NAME"));
                pk.setFkName(rs.getString("FKCOLUMN_NAME"));
                pk.setReferenced(true);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return pkMap;
    }
    
}
