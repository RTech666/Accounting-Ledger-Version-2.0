package com.pluralsight.AccountingLedgerVersion2.handlers;
import com.pluralsight.AccountingLedgerVersion2.Transaction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportHandler {
    // Initalize the ArrayList.
    public static ArrayList<Transaction> transactions = new ArrayList<>();

    // Create main method.
    public static void main(Scanner input) {
        // Run loadTransactions.
        loadTransactions();
    }

    // Create loadTransactions method.
    private static void loadTransactions() {
        try (BufferedReader br = new BufferedReader(new FileReader("logs.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                if (data.length >= 5) {
                    String date = data[0];
                    String time = data[1];
                    String description = data[2];
                    String vendor = data[3];
                    double amount = Double.parseDouble(data[4]);
                    Transaction transaction = new Transaction(date, time, description, vendor, amount);
                    transactions.add(transaction);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Create monthToDate method.
    public static void monthToDate() {
        System.out.println("\nMonth to Date Report");
        for (Transaction transaction : transactions) {
            System.out.println("Month to Date");
            LocalDate currentDate = LocalDate.parse(transaction.getDate());
            LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
            if (currentDate.isAfter(firstDayOfMonth)) {
                transactions.forEach(System.out::println);
                System.out.println(transaction);
            }
        }
    }

    // Create previousMonth method.
    public static void previousMonth() {
        System.out.println("\nPrevious Month Report");
        for (Transaction transaction : transactions) {
            System.out.println("Previous Month");
            LocalDate currentMonth = LocalDate.parse(transaction.getDate());
            LocalDate previousMonth = currentMonth.minusMonths(1);
            if (previousMonth.isBefore(currentMonth)) {
                transactions.forEach(System.out::println);
            }
        }
    }

    // Create yearToDate method.
    public static void yearToDate() {
        System.out.println("\nYear to Date Report");
        for (Transaction transaction : transactions) {
            System.out.println("Year to Date");
            LocalDate yearToDate = LocalDate.parse(transaction.getDate());
            LocalDate firstDayOfYear = yearToDate.withDayOfYear(1);
            if (yearToDate.isAfter(firstDayOfYear)) {
                transactions.forEach(System.out::println);
            }
        }
    }

    // Create previousYear method.
    public static void previousYear() {
        System.out.println("\nPrevious Year Report");
        for (Transaction transaction : transactions) {
            System.out.println("Previous Year");
            LocalDate currentYear = LocalDate.parse(transaction.getDate());
            LocalDate previousYear = currentYear.minusYears(1);
            if (previousYear.isBefore(currentYear)) {
                transactions.forEach(System.out::println);
            }
        }
    }

    // Create searchByVendor method.
    public static void searchByVendor(Scanner input) {
        System.out.print("Please enter the vendor name: ");
        input.nextLine();
        String vendor = input.nextLine();
        transactions.stream().filter(transaction -> transaction.getVendor().equals(vendor)).forEach(System.out::println);
    }
}
