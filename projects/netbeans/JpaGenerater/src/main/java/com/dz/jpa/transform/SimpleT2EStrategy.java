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
    
    public EntityMapping mappingOneStrategy(Entity entity, Properties prop, Map<String, Table> tableMap) {
        EntityMapping mapping = null;
        // 设置映射类型
        Table masterTable = tableMap.get(entity.getTableName());
        PrimaryKey pk = masterTable.getPrimaryKeyMap().get(prop.getColumnName());
        if (pk.isReferenced()) {
            mapping = new EntityMapping();
            Table slaveTable = tableMap.get(pk.getSlaveTable());
            if (slaveTable.isMidTable()) {// many to many
                mapping.setMappingType(Entity.MAPPING_MANY_TO_MANY);
                ForeignKey otherFK = null;
                for (ForeignKey slaveTableFK : slaveTable.getForeignKeyMap().values()) {
                    if (!pk.getFkName().equals(slaveTableFK.getFkName())) {
                        otherFK = slaveTableFK;
                    }
                }
                if (otherFK != null) {
                    mapping.setSlaveClass(formatClassName(otherFK.getMasterTable(), "_"));
                    mapping.setSlaveTable(otherFK.getMasterTable());
                    mapping.setJoinColumns(pk.getFkName());
                    mapping.setInverseJoinColumns(otherFK.getFkName());
                    mapping.setMidTabel(slaveTable.getTableName());
                }
            } else {// one to many
                mapping.setMappingType(Entity.MAPPING_ONE_TO_MANY);
                mapping.setSlaveClass(formatClassName(pk.getSlaveTable(), "_"));
                mapping.setSlaveTable(pk.getSlaveTable());
                mapping.setJoinColumns(pk.getFkName());
            }
        }
        return mapping;
    }
    
    public EntityMapping mappingManyStrategy(ForeignKey fk, Column col, Map<String, Table> tableMap) {
        EntityMapping mapping = new EntityMapping();
        mapping.setProp(entityPropertiesStrategy(col));
        // 设置映射类型
        mapping.setMappingType(Entity.MAPPING_MANY_TO_ONE);
        // 根据类型设置映射信息
        mapping.setMasterTable(fk.getMasterTable());
        mapping.setMasterClass(formatClassName(fk.getMasterTable(), "_"));
        mapping.setJoinColumns(fk.getFkName());
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
