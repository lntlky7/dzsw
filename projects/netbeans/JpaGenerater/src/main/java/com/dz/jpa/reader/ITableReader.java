/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.reader;

import com.dz.jpa.bean.table.Table;
import java.util.Map;

/**
 *
 * @author sz
 */
public interface ITableReader {

    public Map<String, Table> readTable() throws Exception;
}
