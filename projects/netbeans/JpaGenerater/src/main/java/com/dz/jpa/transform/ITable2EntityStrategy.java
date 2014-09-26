/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.transform;

import com.dz.jpa.bean.entity.Entity;
import com.dz.jpa.bean.entity.EntityMapping;
import com.dz.jpa.bean.entity.Properties;
import com.dz.jpa.bean.table.Column;
import com.dz.jpa.bean.table.ForeignKey;
import com.dz.jpa.bean.table.PrimaryKey;
import com.dz.jpa.bean.table.Table;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sz
 */
public interface ITable2EntityStrategy {

    public String entityNameStrategy(String tableName);

    public Properties entityPropertiesStrategy(Column col);

    public List<Properties> entityIdStrategy(PrimaryKey[] pks, Column[] cols);

    public EntityMapping mappingManyStrategy(ForeignKey fk, Column col, Map<String, Table> tableMap);

    public EntityMapping mappingOneStrategy(Entity entity, Properties prop, Map<String, Table> tableMap);
}
