/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.reader.impl;

import com.dz.jpa.bean.table.Column;
import com.dz.jpa.db.JdbcDb;
import com.dz.jpa.reader.IColumnReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sz
 */
public class OracleColumnReader implements IColumnReader {

    @Override
    public Map<String, Column> readTableColumn(String schema, String tableName) throws Exception {
        Map<String, Column> columnMap = new HashMap<String, Column>();
        DatabaseMetaData metaData = null;
        Connection conn = null;
        ResultSet rs = null;
        String remark = "";
        try {
            conn = JdbcDb.getInstance().getConn();
            metaData = conn.getMetaData();
            rs = metaData.getColumns(conn.getCatalog(), schema, tableName, "%");
            while (rs.next()) {
                Column c = new Column();
                c.setName(rs.getString("COLUMN_NAME"));
                c.setType(rs.getInt("DATA_TYPE"));
                c.setTypeName(rs.getString("TYPE_NAME"));
                c.setLength(rs.getInt("COLUMN_SIZE"));
                c.setDecimalDigits(rs.getInt("DECIMAL_DIGITS"));
                c.setDefaultValue(rs.getString("COLUMN_DEF"));
                remark = rs.getString("REMARKS") == null ? "" : rs.getString("REMARKS");
                c.setRemark(remark);
                columnMap.put(c.getName(), c);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return columnMap;
    }

}
