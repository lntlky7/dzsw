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

/**
 *
 * @author sz
 */
public class SimpleTable2Entity implements ITable2Entity {

    public List<Entity> transform(List<Table> tableList) throws Exception {
        // 创建Entity列表
        List<Entity> entityList = new ArrayList<Entity>();
        // 实例化生成策略
        ITable2EntityStrategy strategy = StrategyProxyFactory.getStrategy("");
        // 循环table list处理转换
        for (Table t : tableList) {
            // 实例化Entity对象
            Entity entity = new Entity();
            // 处理表名
            entity.setEntityName(strategy.entityNameStrategy(t.getTableName()));
            // 处理PK
            EntityId entityId = new EntityId();
            int i = 0;
            int size = t.getPrimaryKeyMap().size();
            PrimaryKey[] pks = new PrimaryKey[size];
            Column[] cols = new Column[size];
            for (PrimaryKey pk : t.getPrimaryKeyMap().values()) {
                pks[i] = pk;
                cols[i] = t.getColumnMap().get(pk.getName());
                t.getColumnMap().remove(pk.getName());
                i++;
            }
            entityId.setEntityIdList(strategy.entityIdStrategy(pks, cols));
            entity.setEntityId(entityId);
            // 处理FK
            List<EntityMapping> mappingList = new ArrayList<EntityMapping>();
            for (ForeignKey fk : t.getForeignKeyMap().values()) {
                EntityMapping mapping = strategy.entityMappingStrategy(fk, t.getColumnMap().get(fk.getFkName()));
                t.getColumnMap().remove(fk.getFkName());
                mappingList.add(mapping);
            }
            entity.setEntityMappingList(mappingList);
            // 处理列
            List<Properties> propList = new ArrayList<Properties>();
            for (Column c : t.getColumnMap().values()) {
                Properties p = strategy.entityPropertiesStrategy(c);
                propList.add(p);
            }
            entity.setPropList(propList);
            // 将Entity对象装入Entity列表
            entityList.add(entity);
        }
        // 返回结果
        return entityList;
    }

}
