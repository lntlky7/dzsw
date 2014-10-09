/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.writer.impl;

import com.dz.jpa.Cache;
import com.dz.jpa.bean.entity.Entity;
import com.dz.jpa.utils.SysUtils;
import com.dz.jpa.writer.IWriter;
import com.dz.jpa.writer.IsSetLengthMethod;
import com.dz.jpa.writer.LowerCaseFirstWordMethod;
import com.dz.jpa.writer.UpperCaseFirstWordMethod;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sz
 */
public class SshFileWriter implements IWriter {

    @Override
    public void write(Map<String, Entity> entityMap) throws Exception {
        String baseDir = SysUtils.formatPathFromPackage(Cache.getInstance().getSetting().getPackage(), ".");
        // 创建路径
        File entityDir = new File(Cache.getInstance().getSetting().getOutPath() + "\\ssh\\" + baseDir + "\\entity");
        if (!entityDir.exists()) {
            entityDir.mkdirs();
        }
        File daoDir = new File(Cache.getInstance().getSetting().getOutPath() + "\\ssh\\" + baseDir + "\\dao");
        if (!daoDir.exists()) {
            daoDir.mkdirs();
        }
        File serviceDir = new File(Cache.getInstance().getSetting().getOutPath() + "\\ssh\\" + baseDir + "\\service");
        if (!serviceDir.exists()) {
            serviceDir.mkdirs();
        }
        File actionDir = new File(Cache.getInstance().getSetting().getOutPath() + "\\ssh\\" + baseDir + "\\action");
        if (!actionDir.exists()) {
            actionDir.mkdirs();
        }
        File viewDir = new File(Cache.getInstance().getSetting().getOutPath() + "\\ssh\\" + baseDir + "\\view");
        if (!viewDir.exists()) {
            viewDir.mkdirs();
        }
        // 创建freemark Configure
        Configuration config = new Configuration();
        config.setDefaultEncoding("UTF-8");
        config.setDirectoryForTemplateLoading(new File(Cache.getInstance().getSetting().getTemplatesPath()));
        config.setObjectWrapper(new DefaultObjectWrapper());
        // 写入文件
        for (Entity entity : entityMap.values()) {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("entity", entity);
            data.put("toUpperFirst", new UpperCaseFirstWordMethod());
            data.put("toLowerFirst", new LowerCaseFirstWordMethod());
            data.put("isSetLength", new IsSetLengthMethod());
            // entity
            this.write(config, data, entityDir.getPath() + "\\" + entity.getEntityName() + "Entity.java", "entity.tlp");
            // dao interface
            this.write(config, data, daoDir.getPath() + "\\" + "I" + entity.getEntityName() + "Dao.java", "dao_interface.tlp");
            // dao
            this.write(config, data, daoDir.getPath() + "\\" + entity.getEntityName() + "DaoImpl.java", "dao.tlp");
            // service interface
            this.write(config, data, serviceDir.getPath() + "\\" + "I" + entity.getEntityName() + "Service.java", "service_interface.tlp");
            // service
            this.write(config, data, serviceDir.getPath() + "\\" + entity.getEntityName() + "ServiceImpl.java", "service.tlp");
            // action
            this.write(config, data, actionDir.getPath() + "\\" + entity.getEntityName() + "Action.java", "action.tlp");
            // view
            this.write(config, data, viewDir.getPath() + "\\" + entity.getEntityName() + "View.java", "view.tlp");
        }
    }

    private void write(Configuration config,  Map<String, Object> data, String writeFile, String tlp) throws Exception {
        Writer writer = null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream(writeFile), "UTF-8");
            Template t = config.getTemplate(tlp);
            t.setEncoding("UTF-8");
            t.process(data, writer);
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
