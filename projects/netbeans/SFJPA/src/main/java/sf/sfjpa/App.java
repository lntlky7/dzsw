package sf.sfjpa;

import java.util.logging.Level;
import java.util.logging.Logger;
import sf.sfjpa.common.IConnInfo;
import sf.sfjpa.common.OracleConnInfo;
import sf.sfjpa.db.JdbcDb;

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
            JdbcDb.getInstance().init(connInfo.getDriverName(), connInfo.getUrl(), connInfo.getUser(), connInfo.getPwd());

        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
