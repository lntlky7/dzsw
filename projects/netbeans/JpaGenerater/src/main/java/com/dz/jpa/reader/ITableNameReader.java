/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.reader;

import java.util.List;

/**
 *
 * @author Administrator
 */
public interface ITableNameReader {

    public List<String> readerAllTableName() throws Exception;
}
