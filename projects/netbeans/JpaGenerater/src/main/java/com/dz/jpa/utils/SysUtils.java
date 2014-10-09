/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dz.jpa.utils;

import com.dz.jpa.bean.entity.Properties;

/**
 *
 * @author sz
 */
public class SysUtils {

    /**
     * 首字母转小写
     *
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * 首字母转大写
     *
     * @param s
     * @return
     */
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    public static String formatPathFromPackage(String basePackage, String pattern) {
        String[] ps = basePackage.split(pattern);
        StringBuilder builder = new StringBuilder();
        for (String p : ps) {
            builder.append(p);
            builder.append("\\");
        }
        return builder.toString();
    }

    public static boolean isSetLength(String colTypeName) {
        boolean result = false;
        if (!"DATE".equalsIgnoreCase(colTypeName)
                && !"DATETIME".equalsIgnoreCase(colTypeName)
                && !"TIME".equalsIgnoreCase(colTypeName)
                && !"TIMESTAMP".equalsIgnoreCase(colTypeName)) {
            result = true;
        }
        return result;
    }
}
