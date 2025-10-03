
package com.example.bank;

public class InterestInfoDTO {
    private final boolean isApplicable; // 이자율 적용 대상 여부
    private final double interestRate;  // 이자율

    public InterestInfoDTO(boolean isApplicable, double interestRate) {
        this.isApplicable = isApplicable;
        this.interestRate = interestRate;
    }

    // View가 데이터를 꺼내 쓸 수 있도록 Getter 메서드를 열어둔다.
    public boolean isApplicable() {
        return isApplicable;
    }

    public double getInterestRate() {
        return interestRate;
    }


}