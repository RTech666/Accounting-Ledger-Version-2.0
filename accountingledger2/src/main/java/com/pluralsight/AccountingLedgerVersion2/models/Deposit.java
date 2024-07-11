package com.pluralsight.AccountingLedgerVersion2.models;

public class Deposit {

    private int id;
    private String dateTime;
    private String description;
    private String vendor;
    private double amount;

    //Deafault Constructor
    public Deposit() {
    }

    //Constructor
    public Deposit(int id, String dateTime, String description, String vendor, double amount) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
