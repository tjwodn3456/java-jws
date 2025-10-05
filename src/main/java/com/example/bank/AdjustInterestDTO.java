package com.example.bank;

public class AdjustInterestDTO {
    private final Account account;  // 해당 account 객체
    private final long beforeBalance; // 해당 account 객체의 원금
    private final long afterBalance;

    public AdjustInterestDTO(Account account, long beforeBalance, long afterBalance) {
        this.account = account;
        this.beforeBalance = beforeBalance;
        this.afterBalance = afterBalance;
    }

    public Account getAccount(){
        return account;
    }

    public long getBeforeBalance(){
        return beforeBalance;
    }
    public long getAfterBalance(){
        return afterBalance;
    }
}
