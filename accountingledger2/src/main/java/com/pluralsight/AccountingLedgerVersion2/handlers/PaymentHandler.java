package com.pluralsight.AccountingLedgerVersion2.handlers;
import com.pluralsight.AccountingLedgerVersion2.DateTimeUtil;
import com.pluralsight.AccountingLedgerVersion2.Logger;
import com.pluralsight.AccountingLedgerVersion2.models.Payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PaymentHandler {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/accountingledger";
    private static final String USER = "root";
    private static final String PASS = "Lamaria$4";

    public static void payment(Scanner input) {
        // Ask user the amount for the payment.
        System.out.println("Please enter the amount of the payment: ");
        double amount = input.nextDouble();
        input.nextLine();

        // Ask user for the description for the deposit.
        System.out.println("Please enter a description for your payment: ");
        String description = input.nextLine();

        // Ask user for the vendor for the deposit.
        System.out.println("Please enter the vendor you wish to pay: ");
        String vendor = input.nextLine();

        // Initalize date, time, and transaction variables.
        String date = DateTimeUtil.getCurrentDate();
        String time = DateTimeUtil.getCurrentTime();
        int id = 0;
        Payment payment = new Payment(id, date, time, description, vendor, amount);

        // Send transaction to LedgerHandler.
        //LedgerHandler.add(payment);

        // Save the payment to the database.
        savePaymentToDatabase(payment);

        // Print success message.
        System.out.println("Your transaction has been added");

        // Log the created transaction.
        Logger.log(date + "|" + time + "|" + description + "|" + vendor + "|" + String.format("%.2f", amount));
    }

    private static void savePaymentToDatabase(Payment payment) {
        // Create the query.
        String sql = "INSERT INTO payments (dateTime, description, vendor, amount) VALUES (?, ?, ?, ?)";

        // Connect to the database.
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

             // Add the information to the database.
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, payment.getDate() + " " + payment.getTime());
            pstmt.setString(2, payment.getDescription());
            pstmt.setString(3, payment.getVendor());
            pstmt.setDouble(4, payment.getAmount());
            pstmt.executeUpdate();
            // Print error.
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}