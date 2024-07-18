package com.pluralsight.AccountingLedgerVersion2.models;

public class Ledger {
    private int id;
    private String date;
    private String time;
    private String description;
    private String vendor;
    private double amount;
    private String type;

    //Default constructor
    public Ledger() {
    }

    public Ledger(int id, String date, String time, String description, String vendor, double amount) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    @Override
    public String toString() {
        return
                "\n\t All Transactions \n\t"+
                "Id:" + id +
                        " Date:" + date  +
                        " Time:" + time  +
                        " Description:" + description  +
                        " Vendor:'" + vendor  +
                        " Amount:" + amount ;
    }
    }

