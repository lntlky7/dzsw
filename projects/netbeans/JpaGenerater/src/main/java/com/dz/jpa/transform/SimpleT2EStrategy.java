/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.transform;

import com.dz.jpa.bean.entity.Entity;
import com.dz.jpa.bean.entity.EntityId;
import com.dz.jpa.bean.entity.EntityMapping;
import com.dz.jpa.bean.entity.Properties;
import com.dz.jpa.bean.table.Column;
import com.dz.jpa.bean.table.ForeignKey;
import com.dz.jpa.bean.table.PrimaryKey;
import com.dz.jpa.bean.table.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sz
 */
public class SimpleT2EStrategy implements ITable2EntityStrategy {

    public String entityNameStrategy(String tableName) {
        return formatClassName(tableName, "_");
    }

    public Properties entityPropertiesStrategy(Column col) {
        Properties prop = new Properties();
        prop.setName(formatFieldName(col.getName(), "_"));
        prop.setColumnName(col.getName());
        prop.setType(col.getType());
        prop.setTypeName(col.getTypeName());
        prop.setLength(col.getLength());
        prop.setComment(col.getRemark());
        return prop;
    }

    public List<Properties> entityIdStrategy(PrimaryKey[] pks, Column[] cols) {
        List<Properties> propList = new ArrayList<Properties>();
        for (int i = 0; i < pks.length; i++) {
//            PrimaryKey pk = pks[i];
            Column col = cols[i];
            Properties prop = entityPropertiesStrategy(col);
            propList.add(prop);
        }
        return propList;
    }

    public EntityMapping mappingOneStrategy(Entity entity, Map<String, Table> tableMap) {
        EntityMapping mapping = new EntityMapping();
        // 设置映射类型

        mapping.setMappingType(Entity.MAPPING_ONE_TO_MANY);
        // 根据类型设置映射信息
        switch (1) {
            case Entity.MAPPING_ONE_TO_ONE:
                break;
            case Entity.MAPPING_ONE_TO_MANY:
                mapping.setSlaveClass(null);
                mapping.setSlaveTable(null);
                mapping.setJoinColumns(null);
                break;
        }
        return mapping;
    }

    public EntityMapping mappingManyStrategy(Entity entity, ForeignKey fk, Map<String, Table> tableMap) {
        EntityMapping mapping = new EntityMapping();
        mapping.setProp(entityPropertiesStrategy(null));
        // 设置映射类型

        // 根据类型设置映射信息
        switch (1) {
            case Entity.MAPPING_MANY_TO_ONE:
                break;
            case Entity.MAPPING_MANY_TO_MANY:
                break;
        }
        return mapping;
    }

    public String formatClassName(String tableName, String split) {
        String[] tmp = tableName.toLowerCase().split(split);
        StringBuilder sb = new StringBuilder();
        for (String s : tmp) {
            if (s.equalsIgnoreCase("t")) {
                continue;
            }
            sb.append(this.toUpperCaseFirstOne(s));
        }
        return sb.toString();
    }

    public String formatFieldName(String fieldName, String split) {
        String[] tmp = fieldName.toLowerCase().split(split);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String s : tmp) {
            if (i == 0) {
                sb.append(this.toLowerCaseFirstOne(s));
            } else {
                sb.append(this.toUpperCaseFirstOne(s));
            }
            i++;
        }
        return sb.toString();
    }

    public String formatFieldMethod(String methodName, String fieldName, String split) {
        String[] tmp = fieldName.toLowerCase().split(split);
        StringBuilder sb = new StringBuilder();
        sb.append(methodName);
        for (String s : tmp) {
            sb.append(this.toUpperCaseFirstOne(s));
        }
        return sb.toString();
    }

    /**
     * 首字母转小写
     *
     * @param s
     * @return
     */
    public String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * 首字母转大写
     *
     * @param s
     * @return
     */
    public String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }
}
