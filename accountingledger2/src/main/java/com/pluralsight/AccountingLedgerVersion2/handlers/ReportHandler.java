package com.pluralsight.AccountingLedgerVersion2.handlers;
import com.pluralsight.AccountingLedgerVersion2.Transaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class ReportHandler {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/accountingledger";
    private static final String USER = "root";
    private static final String PASS = "YUm15510n";

    // Create monthToDate method.
    public static void monthToDate() {
        // Print title.
        System.out.println("\nMonth to Date Report");

        // Initalize the variable.
        LocalDate firstDayOfMonth = LocalDate.now().withDayOfMonth(1);

        // Create SQL query.
        String sql = "SELECT * FROM ledger WHERE dateTime >= ?";

        // Connect to database and search the database for the appropiate transactions.
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstDayOfMonth.toString());
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Transaction transaction = extractTransaction(rs);
                    System.out.println(transaction);
                }
            }
        // Print errors, if any.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Create previousMonth method.
    public static void previousMonth() {
        // Print title.
        System.out.println("\nPrevious Month Report");

        // Initalize the variables.
        LocalDate firstDayOfCurrentMonth = LocalDate.now().withDayOfMonth(1);
        LocalDate lastDayOfPreviousMonth = firstDayOfCurrentMonth.minusDays(1);
        LocalDate firstDayOfPreviousMonth = lastDayOfPreviousMonth.withDayOfMonth(1);
        
        // Create SQL query.
        String sql = "SELECT * FROM ledger WHERE dateTime >= ? AND dateTime <= ?";

        // Connect to database and search the database for the appropiate transactions.
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstDayOfPreviousMonth.toString());
            pstmt.setString(2, lastDayOfPreviousMonth.toString());
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Transaction transaction = extractTransaction(rs);
                    System.out.println(transaction);
                }
            }
        // Print errors, if any.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Create yearToDate method.
    public static void yearToDate() {
        // Print title.
        System.out.println("\nYear to Date Report");

        // Initalize the variable.
        LocalDate firstDayOfYear = LocalDate.now().withDayOfYear(1);

        // Create SQL query.
        String sql = "SELECT * FROM ledger WHERE dateTime >= ?";

        // Connect to database and search the database for the appropiate transactions.
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstDayOfYear.toString());
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Transaction transaction = extractTransaction(rs);
                    System.out.println(transaction);
                }
            }
        // Print errors, if any.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Create previousYear method.
    public static void previousYear() {
        // Print title.
        System.out.println("\nPrevious Year Report");

        // Initalize the variables.
        LocalDate firstDayOfCurrentYear = LocalDate.now().withDayOfYear(1);
        LocalDate lastDayOfPreviousYear = firstDayOfCurrentYear.minusDays(1);
        LocalDate firstDayOfPreviousYear = lastDayOfPreviousYear.withDayOfYear(1);

        // Create SQL query.
        String sql = "SELECT * FROM ledger WHERE dateTime >= ? AND dateTime <= ?";

        // Connect to database and search the database for the appropiate transactions.
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstDayOfPreviousYear.toString());
            pstmt.setString(2, lastDayOfPreviousYear.toString());
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Transaction transaction = extractTransaction(rs);
                    System.out.println(transaction);
                }
            }
        // Print errors, if any.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Create searchByVendor method.
    public static void searchByVendor(Scanner input) {
        // Ask user for the vendor name.
        System.out.print("Please enter the vendor name: ");
        String vendor = input.nextLine();

        // Create SQL query.
        String sql = "SELECT * FROM ledger WHERE vendor = ?";

    // Connect to database and search the database for the appropiate transactions.
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vendor);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Transaction transaction = extractTransaction(rs);
                    System.out.println(transaction);
                }
            }
        // Print errors, if any.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Create extractTransaction method.
    private static Transaction extractTransaction(ResultSet rs) throws SQLException {
        // Initalize the variables.
        String date = rs.getString("dateTime").split(" ")[0];
        String time = rs.getString("dateTime").split(" ")[1];
        String description = rs.getString("description");
        String vendor = rs.getString("vendor");
        double amount = rs.getDouble("amount");

        // Return the transaction information.
        return new Transaction(date, time, description, vendor, amount);
    }

    // Create customSearch method.
    public static void customSearch(Scanner input) {
        // Ask user for the start date.
        System.out.print("Enter start date (YYYY-MM-DD) or press enter to leave empty: ");
        String startDate = input.nextLine();

        // Ask user for the end date.
        System.out.print("Enter end date (YYYY-MM-DD) or press enter to leave empty: ");
        String endDate = input.nextLine();

        // Ask user for the description.
        System.out.print("Enter description or press enter to leave empty: ");
        String description = input.nextLine();

        // Ask user for the vendor.
        System.out.print("Enter vendor or press enter to leave empty: ");
        String vendor = input.nextLine();

        // Ask user for the amount.
        System.out.print("Enter amount or press enter to leave empty: ");
        String amountStr = input.nextLine();
        Double amount = amountStr.isEmpty() ? null : Double.parseDouble(amountStr);

        // Create query.
        StringBuilder sql = new StringBuilder("SELECT * FROM ledger WHERE 1=1");
        if (!startDate.isEmpty()) sql.append(" AND dateTime >= ?");
        if (!endDate.isEmpty()) sql.append(" AND dateTime <= ?");
        if (!description.isEmpty()) sql.append(" AND description LIKE ?");
        if (!vendor.isEmpty()) sql.append(" AND vendor LIKE ?");
        if (amount != null) sql.append(" AND amount = ?");

        // Connect to database and search the database for the appropiate transactions.
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            int paramIndex = 1;
            if (!startDate.isEmpty()) pstmt.setString(paramIndex++, startDate);
            if (!endDate.isEmpty()) pstmt.setString(paramIndex++, endDate);
            if (!description.isEmpty()) pstmt.setString(paramIndex++, "%" + description + "%");
            if (!vendor.isEmpty()) pstmt.setString(paramIndex++, "%" + vendor + "%");
            if (amount != null) pstmt.setDouble(paramIndex++, amount);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Transaction transaction = extractTransaction(rs);
                    System.out.println(transaction);
                }
            }
        // Print errors, if any.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
