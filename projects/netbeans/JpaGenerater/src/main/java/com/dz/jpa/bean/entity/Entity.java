/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.bean.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sz
 */
public class Entity {

    public final static int MAPPING_ONE_TO_ONE = 1;
    public final static int MAPPING_ONE_TO_MANY = 2;
    public final static int MAPPING_MANY_TO_ONE = 3;
    public final static int MAPPING_MANY_TO_MANY = 4;

    public final static int ID_GENERATION_STRATEGY_GUID = 1;
    public final static int ID_GENERATION_STRATEGY_AUTO = 2;
    public final static int ID_GENERATION_STRATEGY_SEQUENCE = 3;

    private String packagePrefix;

    private String comment;

    private EntityId entityId;

    private String entityName;

    private String tableName;

    private List<Properties> propList;

    private List<EntityMapping> entityMappingList;

    private String createDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    private String author = "adminstrator";

    public EntityId getEntityId() {
        return entityId;
    }

    public void setEntityId(EntityId entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public List<Properties> getPropList() {
        return propList;
    }

    public void setPropList(List<Properties> propList) {
        this.propList = propList;
    }

    public List<EntityMapping> getEntityMappingList() {
        return entityMappingList;
    }

    public void setEntityMappingList(List<EntityMapping> entityMappingList) {
        this.entityMappingList = entityMappingList;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getPackagePrefix() {
        return packagePrefix;
    }

    public void setPackagePrefix(String packagePrefix) {
        this.packagePrefix = packagePrefix;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
