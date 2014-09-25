package com.dz.jpa;

import com.dz.jpa.bean.table.Table;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.dz.jpa.db.IConnInfo;
import com.dz.jpa.db.OracleConnInfo;
import com.dz.jpa.db.JdbcDb;
import com.dz.jpa.reader.ITableReader;
import com.dz.jpa.reader.TableReaderProxyFactory;
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
            JdbcDb.getInstance().openConn();
            ITableReader nameReader = TableReaderProxyFactory.getReader("com.dz.jpa.reader.impl.OracleTableReader");
            List<Table> tableNameList = nameReader.readTable();
            for (Table t : tableNameList) {
                System.out.println(t.getTableName());
            }
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                JdbcDb.getInstance().closeConn();
            } catch (Exception ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
