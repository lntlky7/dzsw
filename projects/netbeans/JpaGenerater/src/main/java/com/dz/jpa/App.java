package com.dz.jpa;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.dz.jpa.db.IConnInfo;
import com.dz.jpa.db.OracleConnInfo;
import com.dz.jpa.db.JdbcDb;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        String oracleDbType = "oracle";
        String mysqlDbType = "mysql";
        try {
            IConnInfo connInfo = new OracleConnInfo();
            connInfo.loadConnInfo();
            JdbcDb.getInstance().init(connInfo.getDriverName(), connInfo.getUrl(), connInfo.getProps());

        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
