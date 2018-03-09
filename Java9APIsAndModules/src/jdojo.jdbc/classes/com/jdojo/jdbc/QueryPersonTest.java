// QueryPersonTest.java
package com.jdojo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import static java.sql.ResultSet.TYPE_SCROLL_SENSITIVE;
import static java.sql.ResultSet.CONCUR_UPDATABLE;

public class QueryPersonTest {
    // Will be used to format dates  
    private static final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();

            System.out.println("Using Statement Object...");
            useStatement(conn, 101);
            useStatement(conn, 102);

            System.out.println("Using PreparedStatement Object...");
            usePreparedStatement(conn, 101);
            usePreparedStatement(conn, 102);

            // Commit the transaction  
            JDBCUtil.commit(conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JDBCUtil.rollback(conn);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

    public static void useStatement(Connection conn,int personId) throws SQLException {
        String SQL = "select person_id, first_name, last_name, "
                + " gender, dob, income from person "
                + " where person_id = " + personId;

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement(TYPE_SCROLL_SENSITIVE, CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);
            printResultSet(rs);
        } finally {
            // Closing the Statement closes the associated ResultSet   
            JDBCUtil.closeStatement(stmt);
        }
    }

    public static void usePreparedStatement(Connection conn, int personId) throws SQLException {
        String SQL = "select person_id, first_name, last_name, "
                + " gender, dob, income from person "
                + " where person_id = ?";

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(SQL);

            // Set the IN parameter for person_id  
            pstmt.setInt(1, personId);

            // Execute the query  
            rs = pstmt.executeQuery();
            printResultSet(rs);
        } finally {
            // Closing the Statement closes the ResultSet  
            JDBCUtil.closeStatement(pstmt);
        }
    }

    public static void printResultSet(ResultSet rs) throws SQLException {
        while (rs.next()) {
            int personId = rs.getInt("person_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String gender = rs.getString("gender");
            Date dob = rs.getDate("dob");
            boolean isDobNull = rs.wasNull();

            double income = rs.getDouble("income");
            boolean isIncomeNull = rs.wasNull();

            // Format the dob in MM/dd/YYYY format  
            String formattedDob = null;
            if (!isDobNull) {
                formattedDob = formatDate(dob);
            }

            System.out.print("Person ID:" + personId);
            System.out.print(", First Name:" + firstName);
            System.out.print(", Last Name:" + lastName);
            System.out.print(", Gender:" + gender);

            if (isDobNull) {
                System.out.print(", DOB:null");
            } else {
                System.out.print(", DOB:" + formattedDob);
            }

            if (isIncomeNull) {
                System.out.println(", Income:null");
            } else {
                System.out.println(", Income:" + income);
            }
        }
    }

    public static String formatDate(Date dt) {
        if (dt == null) {
            return "";
        }

        String formattedDate = sdf.format(dt);
        return formattedDate;
    }
}
