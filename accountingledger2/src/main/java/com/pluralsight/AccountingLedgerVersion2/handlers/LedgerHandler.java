package com.pluralsight.AccountingLedgerVersion2.handlers;
import com.pluralsight.AccountingLedgerVersion2.Transaction;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerHandler {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/AccountingLedger";
    private static final String USER = "root";
    private static final String PASS = "YUm15510n";

    //public static void addLedgerEntry() {

        // Create the query

        // Connect to the databse


    // Create viewAllTransaction method.
    public static void viewAllTransactions() {
        String sql = "Select * From deposits AND payments";

        // Connect to the database.
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet resultSet = pstmt.executeQuery()) {
            while(resultSet.next())
                pstmt.executeUpdate();
            // Print error.
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    // Create viewAllDeposits method.
    public static void viewAllDeposits() {
            String sql = "SELECT * FROM deposits";
            // Connect to the database.

              try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet resultSet = pstmt.executeQuery()) {
                while(resultSet.next())
                    pstmt.executeUpdate();
                // Print error.
            } catch (SQLException e) {
                System.out.println(e.getMessage());
        }
    }

    // Create viewAllPayments method.
    public static void viewAllPayments() {
            String sql = "SELECT * FROM payments";
            // Connect to the database.
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet resultSet = pstmt.executeQuery()) {
                while(resultSet.next())
                pstmt.executeUpdate();
                // Print error.
            } catch (SQLException e) {
                System.out.println(e.getMessage());
    }
}
}