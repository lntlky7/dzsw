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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sz
 */
public class SimpleTable2Entity implements ITable2Entity {

    public Map<String, Entity> transform(Map<String, Table> tableMap) throws Exception {
        // 创建Entity列表
        Map<String, Entity> entityMap = new HashMap<String, Entity>();
        // 实例化生成策略
        ITable2EntityStrategy strategy = StrategyProxyFactory.getStrategy("");
        // 循环table list处理转换
        for (Table t : tableMap.values()) {
            if (t.isMidTable()) {
                continue;
            }
            // 实例化Entity对象
            Entity entity = new Entity();
            // 处理表名
            entity.setEntityName(strategy.entityNameStrategy(t.getTableName()));
            entity.setTableName(t.getTableName());
            // 处理PK
            EntityId entityId = new EntityId();
            int i = 0;
            int size = t.getPrimaryKeyMap().size();
            PrimaryKey[] pks = new PrimaryKey[size];
            Column[] cols = new Column[size];
            for (PrimaryKey pk : t.getPrimaryKeyMap().values()) {
                pks[i] = pk;
                cols[i] = t.getColumnMap().get(pk.getPkName());
                i++;
            }
            entityId.setEntityIdList(strategy.entityIdStrategy(pks, cols));
            entity.setEntityId(entityId);
            // 处理列
            List<Properties> propList = new ArrayList<Properties>();
            for (Column c : t.getColumnMap().values()) {
                if (!t.getPrimaryKeyMap().containsKey(c.getName()) && !t.getForeignKeyMap().containsKey(c.getName())) {
                    Properties p = strategy.entityPropertiesStrategy(c);
                    propList.add(p);
                }
            }
            entity.setPropList(propList);
            // 将Entity对象装入Entity列表
            entityMap.put(t.getTableName(), entity);
        }
        // 处理类的映射
        for (Table t : tableMap.values()) {
            if (t.isMidTable()) {
                continue;
            }
            Entity entity = entityMap.get(t.getTableName());
            List<EntityMapping> mappingList = new ArrayList<EntityMapping>();
            // one
            EntityMapping mapping = strategy.mappingOneStrategy(entity, tableMap);
            mappingList.add(mapping);
            // many
            for (ForeignKey fk : t.getForeignKeyMap().values()) {
                mapping = strategy.mappingManyStrategy(entity, fk, tableMap);
                mappingList.add(mapping);
            }
            entity.setEntityMappingList(mappingList);
        }
        // 返回结果
        return entityMap;
    }

}
