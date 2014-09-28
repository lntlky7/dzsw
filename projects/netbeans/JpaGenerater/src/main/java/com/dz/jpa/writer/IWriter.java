/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.writer;

import com.dz.jpa.bean.entity.Entity;
import java.util.List;

/**
 *
 * @author sz
 */
public interface IWriter {

    public void write(List<Entity> entityList) throws Exception;
}
