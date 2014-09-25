/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.bean.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sz
 */
public class EntityId {

    private List<Properties> entityIdList;

    private int type;

    public EntityId() {
        this.entityIdList = new ArrayList<Properties>();
    }

    public List<Properties> getEntityIdList() {
        return entityIdList;
    }

    public void setEntityIdList(List<Properties> entityIdList) {
        this.entityIdList = entityIdList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
