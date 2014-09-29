package com.dz.jpa;

import com.dz.jpa.bean.entity.Entity;
import com.dz.jpa.bean.table.Table;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.dz.jpa.db.IConnInfo;
import com.dz.jpa.db.OracleConnInfo;
import com.dz.jpa.db.JdbcDb;
import com.dz.jpa.reader.ITableReader;
import com.dz.jpa.reader.TableReaderProxyFactory;
import com.dz.jpa.transform.ITable2Entity;
import com.dz.jpa.transform.SimpleTable2Entity;
import com.dz.jpa.writer.IWriter;
import com.dz.jpa.writer.WriterProxyFactory;
import java.util.Map;

/**
 *
 *
 */
public class App {

    public static void main(String[] args) {
        try {
            // 获取资源文件参数
            IConnInfo connInfo = new OracleConnInfo();
            connInfo.loadConnInfo();
            ISetting setting = new SimpleFileSetting();
            setting.loadSetting();
            // 设置缓存
            Cache.getInstance().setSetting(setting);
            // 打开数据库连接
            JdbcDb.getInstance().init(connInfo.getDriverName(), connInfo.getUrl(), connInfo.getProps());
            JdbcDb.getInstance().openConn();
            // 读数据库
            ITableReader nameReader = TableReaderProxyFactory.getReader(Cache.getInstance().getSetting().getReader());
            Map<String, Table> tableMap = nameReader.readTable();
            // 转换
            ITable2Entity t2e = new SimpleTable2Entity();
            Map<String, Entity> entityMap = t2e.transform(tableMap);
            // 写入
            IWriter wrtier = WriterProxyFactory.getWriter(Cache.getInstance().getSetting().getWriter());
            wrtier.write(entityMap);
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
