/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.writer;

import com.dz.jpa.bean.entity.Entity;
import java.util.Map;

/**
 *
 * @author sz
 */
public interface IWriter {

    public void write(Map<String, Entity> entityList) throws Exception;
}
