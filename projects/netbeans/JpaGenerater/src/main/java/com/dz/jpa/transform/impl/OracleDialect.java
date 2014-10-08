package com.dz.jpa.transform.impl;

import com.dz.jpa.transform.IDialect;

public class OracleDialect implements IDialect {

    @Override
    public String getJavaType(String dbType, int decimalDigits) {
        String result = "";
        if (dbType != null && !"".equals(dbType)) {
            if ("number".equalsIgnoreCase(dbType)) {
                if (decimalDigits <= 0) {
                    result = "long";
                } else if (decimalDigits > 0 && decimalDigits <= 2)  {
                    result = "float";
                } else {
                    result = "double";
                }
            } else if ("integer".equalsIgnoreCase(dbType)) {
                result = "int";
            } else if ("float".equalsIgnoreCase(dbType)) {
                result = "float";
            } else if ("double".equalsIgnoreCase(dbType)) {
                result = "double";
            } else if (dbType.startsWith("decimal")) {
                result = "BigDecimal";
            } else if (dbType.startsWith("numeric")) {
                result = "long";
            } else if ("numeric".equalsIgnoreCase(dbType)) {
                result = "long";
            } else if ("char".equalsIgnoreCase(dbType)) {
                result = "String";
            } else if ("varchar".equalsIgnoreCase(dbType)) {
                result = "String";
            } else if ("varchar2".equalsIgnoreCase(dbType)) {
                result = "String";
            } else if ("nvarchar".equalsIgnoreCase(dbType)) {
                result = "String";
            } else if ("nvarchar2".equalsIgnoreCase(dbType)) {
                result = "String";
            } else if ("text".equalsIgnoreCase(dbType)) {
                result = "String";
            } else if ("date".equalsIgnoreCase(dbType)) {
                result = "Date";
            } else if ("datetime".equalsIgnoreCase(dbType)) {
                result = "Date";
            } else if ("time".equalsIgnoreCase(dbType)) {
                result = "Date";
            } else if ("timestamp".equalsIgnoreCase(dbType)) {
                result = "Date";
            } else if (dbType.equalsIgnoreCase("blob")) {
                result = "byte[]";
            }
        }
        return result;
    }
}
