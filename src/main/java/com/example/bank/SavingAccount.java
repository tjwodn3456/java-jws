package com.example.bank;

import com.example.calculator.Calculator;

import static com.example.bank.InterestCalculator.calculateInterestRate;

public class SavingAccount extends Account {

    private double savingInterestRate;

    public SavingAccount(String userName, int password, long balance, SavingType savingType, CreditTier creditTier) {
        super(userName, password, balance);
        this.savingInterestRate = calculateInterestRate(savingType, creditTier);
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
    public void adjustInterestRate(double input) {
        this.savingInterestRate = input;
    }
}
