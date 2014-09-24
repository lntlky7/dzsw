package com.dz.jpa;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.dz.jpa.db.IConnInfo;
import com.dz.jpa.db.OracleConnInfo;
import com.dz.jpa.db.JdbcDb;
import com.dz.jpa.reader.ITableNameReader;
import com.dz.jpa.reader.OracleTableNameReader;
import java.util.List;

/**
 * 
 *
 */
public class App {

    public static void main(String[] args) {
        try {
            IConnInfo connInfo = new OracleConnInfo();
            connInfo.loadConnInfo();
            JdbcDb.getInstance().init(connInfo.getDriverName(), connInfo.getUrl(), connInfo.getProps());
            ITableNameReader nameReader = new OracleTableNameReader();
            List<String> tableNameList = nameReader.readerAllTableName();
            for (String tableName : tableNameList) {
                System.out.println(tableName);
            }
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
