package com.pluralsight.AccountingLedgerVersion2;
import com.pluralsight.AccountingLedgerVersion2.handlers.DepositHandler;
import com.pluralsight.AccountingLedgerVersion2.handlers.PaymentHandler;
import java.util.Scanner;

public class Home {
    public static void main(String[] args) {
        // Initalize the scanner.
        Scanner input = new Scanner(System.in);

        // Initalize the variable.
        boolean running = true;

        // Print homeTitle.
        homeTitle();

        while (running) {
            // Print menu choices.
            System.out.println("Please choose an option:");
            System.out.println("1: Make a Deposit");
            System.out.println("2: Make a Payment");
            System.out.println("3: Ledger Menu");
            System.out.println("4: Quit");

            // Allow use to enter their choice.
            int choice = input.nextInt();

            // Read the user input and execute the appropriate method.
            switch (choice) {
                case 1:
                    DepositHandler.deposit(input);
                    break;
                case 2:
                    PaymentHandler.payment(input);
                    break;
                case 3:
                    LedgerHome.ledgerHome(input);
                    break;
                case 4:
                    running = false;
                    closeApplication();
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;
            }
        }

        // Close scanner.
        input.close();
    }

    // Create homeTitle method.
    private static void homeTitle() {
        // Print home title.
        System.out.println("    ___                         __  _             __          __            \r\n" +
                           "   / _ |___________  __ _____  / /_(_)__  ___ _  / /  ___ ___/ /__ ____ ____\r\n" +
                           "  / __ / __/ __/ _ \\/ // / _ \\/ __/ / _ \\/ _ `/ / /__/ -_) _  / _ `/ -_) __/\r\n" +
                           " /_/ |_\\__/\\__/\\___/\\_,_/_//_/\\__/_/_//_/\\_, / /____/\\__/\\_,_/\\_, /\\__/_/   \r\n" +
                           "                                        /___/                /___/          \r\n" +
                           "--- Version 2 --- \r\n");
    }

    // Create closeApplication method.
    private static void closeApplication() {
        // Print close messsage.
        System.out.println("Thank you for using the Accounting Ledger!");

        // Close program.
        System.exit(0);
    }
}