package sf.sfjpa;

import java.util.logging.Level;
import java.util.logging.Logger;
import sf.sfjpa.common.JdbcProp;
import sf.sfjpa.db.JdbcDb;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        try {
            JdbcProp jp = JdbcProp.getInstance();
            jp.init();
            JdbcDb.getInstance().init(jp.getDriverName(), jp.getUrl(), jp.getUserName(), jp.getUserPwd());

        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
