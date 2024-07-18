package com.pluralsight.AccountingLedgerVersion2.handlers;
import com.pluralsight.AccountingLedgerVersion2.Transaction;
import com.pluralsight.AccountingLedgerVersion2.models.Deposit;
import com.pluralsight.AccountingLedgerVersion2.models.Ledger;
import com.pluralsight.AccountingLedgerVersion2.models.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LedgerHandler {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/AccountingLedger";
    private static final String USER = "root";
    private static final String PASS = "Lamaria$4";

    //public static void addLedgerEntry() {

        // Create the query

        // Connect to the database


    // Create viewAllTransaction method.
    public static List<Transaction> viewAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "Select * From deposits UNION Select * From payments ";

        // Connect to the database.
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql) ;
             ResultSet resultSet = pstmt.executeQuery()) {
            while(resultSet.next()){
                //int id = resultSet.getInt("id");
                String date = resultSet.getString("dateTime");
                String time = String.valueOf(resultSet.getTimestamp(2));
                String description = resultSet.getString("description");
                String vendor = resultSet.getString("vendor");
                double amount = resultSet.getDouble("amount");
                Transaction transaction = new Transaction(date,time,description,vendor,amount);
                transactions.add(transaction);
               // System.out.println("\n\t All Transactions");
                System.out.println(transaction);
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return transactions;
    }
    // Create viewAllDeposits method.
    public static List<Deposit> viewAllDeposits() {
        List<Deposit> deposits = new ArrayList<>();
        String sql = "SELECT * FROM deposits";
        // Connect to the database.
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet resultSet = pstmt.executeQuery()) {
            while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String date = resultSet.getString("dateTime");
                    String time = String.valueOf(resultSet.getTimestamp(2));
                    String description = resultSet.getString("description");
                    String vendor = resultSet.getString("vendor");
                    double amount = resultSet.getDouble("amount");
                    Deposit deposit = new Deposit(id,date,time,description,vendor,amount);
                    deposits.add(deposit);
               // System.out.println("\n\t All Deposits");
                System.out.println(deposits);
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return deposits;
    }

    // Create viewAllPayments method.
    public static List<Payment> viewAllPayments() {
        List<Payment> payments = new ArrayList<>();
            String sql = "SELECT * FROM payments";
            // Connect to the database.
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet resultSet = pstmt.executeQuery()) {
                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String date = resultSet.getString("dateTime");
                    String time = String.valueOf(resultSet.getTimestamp(2));
                    String description = resultSet.getString("description");
                    String vendor = resultSet.getString("vendor");
                    double amount = resultSet.getDouble("amount");
                   Payment payment = new Payment(id,date,time,description,vendor,amount);
                   payments.add(payment);
                    //System.out.println("\n\t All Payments");
                    System.out.println(payments);
            }
    } catch (SQLException e) {
                System.out.println(e.getMessage());
    }
        return payments;
    }
}

