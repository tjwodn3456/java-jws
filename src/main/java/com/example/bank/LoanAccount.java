package com.example.bank;

public class LoanAccount extends Account implements AccountUtility {

    private double loanInterestRate;

    public LoanAccount(String userName, int password, long balance, double loanInterestRate) {
        super(userName, password, balance);
        this.loanInterestRate = loanInterestRate;
    }

    // 대출 이자 차감
    @Override
    public void adjustBalance() {
        long interest = -((long) ((balance * (this.loanInterestRate / 100.0))));
        changeBalance(interest);
    }
    // 대출 이자율 확인
    @Override
    public double getInterestRate() {
        return this.loanInterestRate;
    }

    // Account Benefit : 이자율 조정
    @Override
    public void adjustInterestRate(double amount) {
        this.loanInterestRate = amount;
    }
}