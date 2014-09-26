/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dz.jpa.transform;

/**
 *
 * @author sz
 */
public interface IDialect {
    
    public String getJavaType(String typeName);
    
//    public String getJaveType(int type);
}
