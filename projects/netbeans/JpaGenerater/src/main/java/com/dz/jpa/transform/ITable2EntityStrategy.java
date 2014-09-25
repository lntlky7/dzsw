/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.transform;

import com.dz.jpa.bean.entity.EntityMapping;
import com.dz.jpa.bean.entity.Properties;
import com.dz.jpa.bean.table.Column;
import com.dz.jpa.bean.table.ForeignKey;
import com.dz.jpa.bean.table.PrimaryKey;
import java.util.List;

/**
 *
 * @author sz
 */
public interface ITable2EntityStrategy {

    public String entityNameStrategy(String tableName);

    public Properties entityPropertiesStrategy(Column col);

    public List<Properties> entityIdStrategy(PrimaryKey[] pks, Column[] cols);

    public EntityMapping entityMappingStrategy(ForeignKey fk, Column col);
}
