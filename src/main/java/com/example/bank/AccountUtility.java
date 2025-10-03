package com.example.bank;

public interface AccountUtility {



    //각 계좌 종류별 이율 확인 (저축 이율, 대출 이율)
    abstract double getInterestRate();

    //각 계좌 종류별 이율 조정 (저축 이율, 대출 이율)
    abstract void adjustInterestRate(double amount);

    // 각 계좌별 이자 지급 or 차감 (저축 or 대출)
    abstract void adjustBalance();
}
