package com.pluralsight.AccountingLedgerVersion2;
import com.pluralsight.AccountingLedgerVersion2.handlers.LedgerHandler;
import java.util.Scanner;

public class LedgerHome {
    // Create main method.
    public static void main(Scanner input) {
        // Run ledgerHome.
        ledgerHome(input);
    }

    public static void ledgerHome(Scanner input) {
        // Initalize the variable.
        boolean running = true;

        while (running) {
            // Print menu choices.
            System.out.println("Please choose an option:");
            System.out.println("1: View all Transactions.");
            System.out.println("2: View all Deposits.");
            System.out.println("3: View all Payments.");
            System.out.println("4: View Reports.");
            System.out.println("5: Return to Home.");

            // Allow use to enter their choice.
            int choice = input.nextInt();

            // Read the user input and execute the appropriate method.
            switch (choice) {
                case 1:
                    LedgerHandler.viewAllTransactions();
                    break;
                case 2:
                    LedgerHandler.viewAllDeposits();
                    break;
                case 3:
                    LedgerHandler.viewAllPayments();
                    break;
                case 4:
                    ReportsHome.reportsHome(input);
                    break;
                case 5:
                    running = false;
                    Home.main(null);
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;
            }
        }
    }
}