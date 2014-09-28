package com.dz.jpa;

import com.dz.jpa.bean.table.Table;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.dz.jpa.db.IConnInfo;
import com.dz.jpa.db.OracleConnInfo;
import com.dz.jpa.db.JdbcDb;
import com.dz.jpa.reader.ITableReader;
import com.dz.jpa.reader.TableReaderProxyFactory;
import java.util.Map;

/**
 * 
 *
 */
public class App {

    public static void main(String[] args) {
        try {
            IConnInfo connInfo = new OracleConnInfo();
            connInfo.loadConnInfo();
            ISetting setting = new SimpleFileSetting();
            setting.loadSetting();
            Cache.getInstance().setSetting(setting);
            JdbcDb.getInstance().init(connInfo.getDriverName(), connInfo.getUrl(), connInfo.getProps());
            JdbcDb.getInstance().openConn();
            ITableReader nameReader = TableReaderProxyFactory.getReader(Cache.getInstance().getSetting().getReader());
            Map<String, Table> tableMap = nameReader.readTable();
            for (Table t : tableMap.values()) {
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
