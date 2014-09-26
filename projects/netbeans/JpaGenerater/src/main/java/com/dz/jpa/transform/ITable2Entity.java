/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.transform;

import com.dz.jpa.bean.entity.Entity;
import com.dz.jpa.bean.table.Table;
import java.util.Map;

/**
 *
 * @author sz
 */
public interface ITable2Entity {

    public Map<String, Entity> transform(Map<String, Table> tableMap) throws Exception;

}
