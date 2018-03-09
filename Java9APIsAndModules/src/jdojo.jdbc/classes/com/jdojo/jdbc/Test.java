// Test.java
package com.jdojo.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {    
        DriverManager.drivers()
                .forEach(System.out::println);
        
    }
}
