/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.bean;

/**
 *
 * @author sz
 */
public class Entity {

    public static int MAPPING_ONE_TO_ONE = 1;
    public static int MAPPING_ONE_TO_MANY = 2;
    public static int MAPPING_MANY_TO_ONE = 3;
    public static int MAPPING_MANY_TO_MANY = 4;

    public static int ID_GENERATION_STRATEGY_GUID = 1;
    public static int ID_GENERATION_STRATEGY_AUTO = 2;
    public static int ID_GENERATION_STRATEGY_SEQUENCE = 3;

}
