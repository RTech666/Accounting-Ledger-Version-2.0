package com.pluralsight.AccountingLedgerVersion2;
import com.pluralsight.AccountingLedgerVersion2.handlers.ReportHandler;
import java.util.Scanner;

public class ReportsHome {
    // Create main method.
    public static void main(Scanner input) {
        // Run reportsHome.
        reportsHome(input);
    }

    public static void reportsHome(Scanner input) {
        // Initalize the variable.
        boolean running = true;

        while (running) {
            // Print menu choices.
            System.out.println("\nPlease choose an option:");
            System.out.println("1: Month to Date");
            System.out.println("2: Previous Month");
            System.out.println("3: Year to Date");
            System.out.println("4: Previous Year");
            System.out.println("5: Search by vendor");
            System.out.println("6: Go Back");

            // Allow user to enter their choice.
            int choice = input.nextInt();
            input.nextLine();

            // Read the user input and execute the appropriate method.
            switch (choice) {
                case 1:
                    ReportHandler.monthToDate();
                    break;
                case 2:
                    ReportHandler.previousMonth();
                    break;
                case 3:
                    ReportHandler.yearToDate();
                    break;
                case 4:
                    ReportHandler.previousYear();
                    break;
                case 5:
                    ReportHandler.searchByVendor(input);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;
            }
        }
    }
}