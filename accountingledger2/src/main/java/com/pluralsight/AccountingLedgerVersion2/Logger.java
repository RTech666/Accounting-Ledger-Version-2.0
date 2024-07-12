package com.pluralsight.AccountingLedgerVersion2;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    public static void log(String action) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("logs.csv", true));
            writer.write(action);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}