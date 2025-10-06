package com.example.bank;

import static com.example.bank.InterestCalculator.calculateInterestRate;

public class LoanAccount extends Account {

    private double loanInterestRate;
    
    // 생성자
    public LoanAccount(String userName, int password, long balance, LoanType loanType, CreditTier creditTier) {
        super(userName, password, balance);
        this.loanInterestRate = calculateInterestRate(loanType, creditTier);
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