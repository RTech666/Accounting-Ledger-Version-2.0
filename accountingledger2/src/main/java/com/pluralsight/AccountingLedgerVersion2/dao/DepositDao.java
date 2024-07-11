package com.pluralsight.AccountingLedgerVersion2.dao;

import com.pluralsight.AccountingLedgerVersion2.models.Deposit;

public interface DepositDao {
    void deposit(Deposit deposit);
}
