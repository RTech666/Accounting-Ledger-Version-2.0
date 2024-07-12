package com.pluralsight.AccountingLedgerVersion2.handlers;
import com.pluralsight.AccountingLedgerVersion2.Transaction;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerHandler {
    // Initalize the ArrayList.
    public static ArrayList<Transaction> transactions = new ArrayList<>();

    // Create main method.
    public static void main(Scanner input) {
        // Run loadTransactions.
        loadTransactions();
    }

    public static void loadTransactions() {
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

    // Create viewAllTransaction method.
    public static void viewAllTransactions() {
        transactions.forEach(System.out::println);
    }

    // Create viewAllDeposits method.
    public static void viewAllDeposits() {
        transactions.stream().filter(transaction -> transaction.getAmount() > 0).forEach(System.out::println);
    }

    // Create viewAllPayments method.
    public static void viewAllPayments() {
        transactions.stream().filter(transaction -> transaction.getAmount() < 0).forEach(System.out::println);
    }
}