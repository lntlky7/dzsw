package com.dz.jpa.transform;

public class OracleDialect implements IDialect {

    @Override
    public String getJavaType(String dbType) {
        String result = "";
        if (dbType != null && !"".equals(dbType)) {
            if ("int".equalsIgnoreCase(dbType)) {
                result = "int";
            } else if ("integer".equalsIgnoreCase(dbType)) {
                result = "int";
            } else if ("tinyint".equalsIgnoreCase(dbType)) {
                result = "int";
            } else if ("float".equalsIgnoreCase(dbType)) {
                result = "double";
            } else if ("double".equalsIgnoreCase(dbType)) {
                result = "double";
            } else if ("text".equalsIgnoreCase(dbType)) {
                result = "String";
            } else if (dbType.startsWith("varchar")) {
                result = "String";
            } else if (dbType.startsWith("nvarchar")) {
                result = "String";
            } else if ("date".equalsIgnoreCase(dbType)) {
                result = "Date";
            } else if ("datetime".equalsIgnoreCase(dbType)) {
                result = "Date";
            } else if ("time".equalsIgnoreCase(dbType)) {
                result = "Date";
            } else if ("timestamp".equalsIgnoreCase(dbType)) {
                result = "Date";
            } else if (dbType.startsWith("decimal")) {
                result = "BigDecimal";
            } else if (dbType.startsWith("numeric")) {
                result = "long";
            } else if ("numeric".equalsIgnoreCase(dbType)) {
                result = "long";
            } else if (dbType.equalsIgnoreCase("blob")) {
                result = "byte[]";
            }
        }
        return result;
    }
}
