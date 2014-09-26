/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.reader.impl;

import com.dz.jpa.bean.table.ForeignKey;
import com.dz.jpa.db.JdbcDb;
import com.dz.jpa.reader.IFKReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sz
 */
public class OracleFKReader implements IFKReader {

    public Map<String, ForeignKey> readTableFK(String tableName) throws Exception {
        Map<String, ForeignKey> fkMap = new HashMap<String, ForeignKey>();
        DatabaseMetaData metaData = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = JdbcDb.getInstance().getConn();
            metaData = conn.getMetaData();
            rs = metaData.getImportedKeys(null, null, tableName);
            while (rs.next()) {
                ForeignKey fk = new ForeignKey();
                fk.setMasterTable(rs.getString("PKTABLE_NAME"));
                fk.setSlaveTable(rs.getString("FKTABLE_NAME"));
                fk.setPkName(rs.getString("PKCOLUMN_NAME"));
                fk.setFkName(rs.getString("FKCOLUMN_NAME"));
                fkMap.put(fk.getFkName(), fk);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return fkMap;
    }

}
