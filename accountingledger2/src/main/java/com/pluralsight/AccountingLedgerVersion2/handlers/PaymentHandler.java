package com.pluralsight.AccountingLedgerVersion2.handlers;
import com.pluralsight.AccountingLedgerVersion2.DateTimeUtil;
import com.pluralsight.AccountingLedgerVersion2.Logger;
import com.pluralsight.AccountingLedgerVersion2.Transaction;
import java.util.Scanner;

public class PaymentHandler {
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
        Transaction transaction = new Transaction(date, time, description, vendor, amount);

        // Send transaction to LedgerHandler.
        LedgerHandler.transactions.add(transaction);

        // Print success message.
        System.out.println("Your transaction has been added");

        // Log the created transaction.
        Logger.log(date + "|" + time + "|" + description + "|" + vendor + "|" + String.format("%.2f", amount));
    }
}