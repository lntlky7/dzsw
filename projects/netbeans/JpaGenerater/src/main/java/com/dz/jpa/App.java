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
import com.dz.jpa.transform.impl.SimpleTable2Entity;
import com.dz.jpa.writer.IWriter;
import com.dz.jpa.writer.WriterProxyFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            IAdvancedSetting advSetting = new SimpleFileAdvancedSetting();
            advSetting.loadSetting();
            System.out.println("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +"]参数设置完毕");
            // 设置缓存
            Cache.getInstance().setSetting(setting);
            Cache.getInstance().setAdvancedSetting(advSetting);
            System.out.println("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +"]缓存设置完毕");
            // 打开数据库连接
            JdbcDb.getInstance().init(connInfo.getDriverName(), connInfo.getUrl(), connInfo.getProps());
            JdbcDb.getInstance().openConn();
            System.out.println("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +"]打开数据库连接");
            // 读数据库
            ITableReader nameReader = TableReaderProxyFactory.getReader(Cache.getInstance().getSetting().getReader());
            System.out.println("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +"]开始读取表结构");
            Map<String, Table> tableMap = nameReader.readTable();
            // 转换
            ITable2Entity t2e = new SimpleTable2Entity();
            System.out.println("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +"]开始转换成实体数据");
            Map<String, Entity> entityMap = t2e.transform(tableMap);
            // 写入
            IWriter wrtier = WriterProxyFactory.getWriter(Cache.getInstance().getSetting().getWriter());
            System.out.println("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +"]开始写入文件");
            wrtier.write(entityMap);
            System.out.println("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +"]生成成功");
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +"]生成失败");
        } finally {
            try {
                JdbcDb.getInstance().closeConn();
            } catch (Exception ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
