package com.example.bank;

import java.util.Arrays;
import java.util.List;

public enum LoanType implements Product{
    // 우선은 Saving 이랑 반대로 이율 개념을 작성
    // 추후 로직을 바꿔야 더 시각적 개선 가능
    ADULT_HOPE_LOANS(18.0, 8.0),
    ;

    // 최대, 최소 이율
    private final double minRate;
    private final double maxRate;

    // 생성자
    private LoanType(double minRate, double maxRate) {
        this.minRate = minRate;
        this.maxRate = maxRate;
    }

    // Loan 상품 목록 찾기
    public List<LoanType> getLoanProducts(){
        return Arrays.asList(LoanType.values());
    }


    //Getter
    public double getMinRate() {
        return this.minRate;
    }
    public double getMaxRate() {
        return this.maxRate;
    }
}

