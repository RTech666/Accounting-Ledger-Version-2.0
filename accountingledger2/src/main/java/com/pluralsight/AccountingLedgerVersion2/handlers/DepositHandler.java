package com.pluralsight.AccountingLedgerVersion2.handlers;
import com.pluralsight.AccountingLedgerVersion2.DateTimeUtil;
import com.pluralsight.AccountingLedgerVersion2.Logger;
import com.pluralsight.AccountingLedgerVersion2.models.Deposit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DepositHandler {
    // Initalize the varibles for the database connection.
    private static final String DB_URL = "jdbc:mysql://localhost:3306/accountingledger";
    private static final String USER = "root";
    private static final String PASS = "YUm15510n";

    public static void deposit(Scanner input) {
        // Ask user the amount for the deposit.
        System.out.println("Please enter the amount of the deposit: ");
        double amount = input.nextDouble();
        input.nextLine();

        // Ask user for the description for the deposit.
        System.out.println("Please enter a description for your deposit: ");
        String description = input.nextLine();

        // Ask user for the vendor for the deposit.
        System.out.println("Please enter the vendor from which to deposit: ");
        String vendor = input.nextLine();

        // Initialize date, time, and transaction variables.
        String date = DateTimeUtil.getCurrentDate();
        String time = DateTimeUtil.getCurrentTime();
        int id = 0;
        Deposit deposit = new Deposit(id, date, time, description, vendor, amount);

        // Save transaction to the database
        saveDepositToDatabase(deposit);

        // Print success message.
        System.out.println("Your transaction has been added");

        // Log the created transaction.
        Logger.log(date + "|" + time + "|" + description + "|" + vendor + "|" + String.format("%.2f", amount));
    }

    private static void saveDepositToDatabase(Deposit deposit) {
        // Create the query.
        String sql = "INSERT INTO deposits (dateTime, description, vendor, amount) VALUES (?, ?, ?, ?)";

        // Connect to the database.
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        // Add the information to the database.
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, deposit.getDate() + " " + deposit.getTime());
            pstmt.setString(2, deposit.getDescription());
            pstmt.setString(3, deposit.getVendor());
            pstmt.setDouble(4, deposit.getAmount());
            pstmt.executeUpdate();
        // Print error.
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}