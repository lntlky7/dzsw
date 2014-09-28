/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.writer;

import com.dz.jpa.Cache;
import com.dz.jpa.bean.entity.Entity;
import com.dz.jpa.utils.SysUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

/**
 *
 * @author sz
 */
public class SshFileWriter implements IWriter {

    @Override
    public void write(List<Entity> entityList) throws Exception {
        String baseDir = SysUtils.formatPathFromPackage(Cache.getInstance().getSetting().getPackage(), ".");
        // 创建路径
        File entityDir = new File(Cache.getInstance().getSetting().getOutPath() + "\\ssh\\" + baseDir + "\\");
        if (!entityDir.exists()) {
            entityDir.mkdirs();
        }
        File daoDir = new File(Cache.getInstance().getSetting().getOutPath() + "\\ssh\\" + baseDir + "\\");
        if (!daoDir.exists()) {
            daoDir.mkdirs();
        }
        File serviceDir = new File(Cache.getInstance().getSetting().getOutPath() + "\\ssh\\" + baseDir + "\\");
        if (!serviceDir.exists()) {
            serviceDir.mkdirs();
        }
        File actionDir = new File(Cache.getInstance().getSetting().getOutPath() + "\\ssh\\" + baseDir + "\\");
        if (!actionDir.exists()) {
            actionDir.mkdirs();
        }
        // 创建freemark Configure
        Configuration config = new Configuration();
        config.setClassForTemplateLoading(SshFileWriter.class, "templates\\ssh");
        // 写入文件
        for (Entity entity : entityList) {
            // entity
            this.write(config, entity, baseDir + entity.getEntityName() + "Entity.java", "entity.tlp");
            // dao interface
            this.write(config, entity, baseDir + "I" + entity.getEntityName() + "Dao.java", "dao_interface.tlp");
            // dao
            this.write(config, entity, baseDir + entity.getEntityName() + "DaoImpl.java", "dao.tlp");
            // service interface
            this.write(config, entity, baseDir + "I" + entity.getEntityName() + "Service.java", "service_interface.tlp");
            // service
            this.write(config, entity, baseDir + entity.getEntityName() + "ServiceImpl.java", "service.tlp");
            // action
            this.write(config, entity, baseDir + entity.getEntityName() + "Action.java", "action.tlp");
        }
    }

    private void write(Configuration config, Entity entity, String writeFile, String tlp) throws Exception {
        Writer writer = null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream(writeFile));
            Template t = config.getTemplate(tlp);
            t.process(entity, writer);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
