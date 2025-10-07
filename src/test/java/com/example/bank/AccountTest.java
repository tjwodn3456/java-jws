package com.example.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void deposit_increases_balance() {
        Account account = new Account("testuser", 1234, 10000);
        account.deposit(5000L);
        assertEquals(15000L, account.getBalance());
    }
    @Test
    void withdraw_check(){
        Account account = new Account("testuser", 1234, 10000);
        account.withdraw(3000L);
        assertEquals(7000L, account.getBalance());
    }
}