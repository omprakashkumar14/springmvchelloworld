package com.iddr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcApp {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            
            // Database connection details
            String url = "jdbc:mysql://localhost:3306/octbatch";  // Change 'octbatch' to your database name
            String user = "root";
            String password = "root";
            
            // Establish connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully");
            
            // Create statement object
            statement = connection.createStatement();
            System.out.println("Statement object created");
            
            // Execute SQL query
            String sqlSelectQuery = "SELECT sid, sname, sage, saddress FROM student";
            resultSet = statement.executeQuery(sqlSelectQuery);
            
            // Process result set
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("sid") + "\t" +
                                   resultSet.getString("sname") + "\t" +
                                   resultSet.getInt("sage") + "\t" +
                                   resultSet.getString("saddress"));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException se) {
            System.out.println("SQL Error: " + se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                System.out.println("Resources closed");
            } catch (SQLException e) {
                System.out.println("Error while closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
