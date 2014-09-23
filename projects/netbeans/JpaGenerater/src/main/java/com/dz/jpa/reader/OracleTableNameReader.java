/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.reader;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.dz.jpa.db.JdbcDb;

/**
 *
 * @author Administrator
 */
public class OracleTableNameReader implements ITableNameReader {

    public List<String> readerAllTableName() throws Exception {
        List<String> list = new ArrayList<String>();
        // 查询所有表名
        String tableNameSql = "SELECT TABLE_NAME FROM USER_TABLES";
        JdbcDb.getInstance().openConn();
        PreparedStatement pstmt = JdbcDb.getInstance().getConn().prepareStatement(tableNameSql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            list.add(rs.getString("TABLE_NAME"));
        }
        return list;
    }

}
