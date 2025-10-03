package com.example.bank;

public class SavingAccount extends Account implements AccountUtility {

    private double savingInterestRate;

    public SavingAccount(String userName, int password, long balance, double interestRate) {
        super(userName, password, balance);
        this.savingInterestRate = interestRate;
    }

    // 이자 지급
    @Override
    public void adjustBalance() {
        long interest = (long) ((balance * (this.savingInterestRate / 100.0)));
        changeBalance(interest);
    }
    // 저축 이자율 확인
    @Override
    public double getInterestRate() {
        return this.savingInterestRate;
    }
    // Account Benefit : 이자율 조정
    @Override
    public void adjustInterestRate(double amount) {
        this.savingInterestRate = amount;
    }
}
