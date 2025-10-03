package com.example.bank;

public class AdjustBalaneInfoDTO {
    private final Account account;  // 해당 account 객체
    private final long beforeBalance; // 해당 account 객체의 원금

    public AdjustBalaneInfoDTO(Account account, long beforeBalance) {
        this.account = account;
        this.beforeBalance = beforeBalance;
    }

    public Account account(){
        return account;
    }

    public long getBeforeBalance(){
        return beforeBalance;
    }

}
