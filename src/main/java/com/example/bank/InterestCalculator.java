package com.example.bank;

public class InterestCalculator {

    // SavingType 이율 계산 : +
    // min 이율 부여 후 신용 등급 높을 수록 많이 증가
    public static double calculateInterestRate(SavingType savingType, CreditTier creditTier){
        return savingType.getMinRate() + creditTier.getAdjustmentRate();
    }

    // LoanType 이율 계산 : - 
    // max 이율 부여 후 신용 등급 높을 수록 많이 차감
    public static double calculateInterestRate(LoanType loanType, CreditTier creditTier) {
        return loanType.getMaxRate() - creditTier.getAdjustmentRate();
    }
}
