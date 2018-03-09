// PrintJDBCDrivers.java
package com.jdojo.jdbc;

import java.sql.Driver;
import java.sql.DriverManager;

public class PrintJDBCDrivers {
    public static void main(String[] args) {
        System.out.println("List of loaded JDBC drivers:");
        DriverManager.drivers()
                .forEach(PrintJDBCDrivers::print);
    }

    public static void print(Driver driver) {
        String className = driver.getClass().getName();
        String moduleName = driver.getClass().getModule().getName();
        int majorVersion = driver.getMajorVersion();
        int minorVersion = driver.getMinorVersion();
        boolean jdbcCompliant = driver.jdbcCompliant();
        
        System.out.println("Driver Class Name: " + className);
        System.out.println("Driver Module Name: " + moduleName);
        System.out.println("Driver Major Version: " + majorVersion);
        System.out.println("Driver Minor Version: " + minorVersion);
        System.out.println("Driver jdbcCompliant: " + jdbcCompliant);        
        System.out.println("----------------------------------------");
    }
}
