package com.pluralsight.AccountingLedgerVersion2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountingLedgerVersion2Application {

    public static void main(String[] args) {
        SpringApplication.run(AccountingLedgerVersion2Application.class, args);
        Home.main(args);
    }

}