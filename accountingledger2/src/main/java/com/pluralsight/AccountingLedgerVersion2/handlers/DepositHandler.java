package com.pluralsight.AccountingLedgerVersion2.handlers;
import com.pluralsight.AccountingLedgerVersion2.DateTimeUtil;
import com.pluralsight.AccountingLedgerVersion2.Logger;
import com.pluralsight.AccountingLedgerVersion2.Transaction;
import java.util.Scanner;

public class DepositHandler {
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

        // Initalize date, time, and transaction variables.
        String date = DateTimeUtil.getCurrentDate();
        String time = DateTimeUtil.getCurrentTime();
        Transaction transaction = new Transaction(date, time, description, vendor, amount);

        // Send transaction to LedgerHandler.
        LedgerHandler.transactions.add(transaction);

        // Print success message.
        System.out.println("Your transaction has been added");

        // Log the created transaction.
        Logger.log(date + "|" + time + "|" + description + "|" + vendor + "|" + String.format("%.2f", amount));
    }
}