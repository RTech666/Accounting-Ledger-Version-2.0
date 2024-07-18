package com.pluralsight.AccountingLedgerVersion2.handlers;
import com.pluralsight.AccountingLedgerVersion2.Transaction;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerHandler {


    public static void addLedgerEntry() {
        // Create the query


        // Connect to the databse


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