package com.example.bank;

import java.util.Arrays;
import java.util.List;

public enum CreditTier {
    A(5.0),
    B(4.0),
    C(3.0);

    
    // 조정 금리
    private final double adjustmentRate;
    
    
    // 생성자
    private CreditTier (double adjustmentRate) {
        this.adjustmentRate = adjustmentRate;
    }

    // 사용자 입력 값이 일치하면 enum 타입으로 변환
    public static CreditTier fromString(String input){
        List<CreditTier> CreditTier = getCreditTier();
        for (CreditTier type : CreditTier) {
            if (type.name().equals(input)) {
                return type;
            }
        }
        return null;
    }

    // Saving 상품 목록 찾기
    public static List<CreditTier> getCreditTier(){
        return Arrays.asList(CreditTier.values());
    }


    //Getter
    public double getAdjustmentRate() {
        return this.adjustmentRate;
    }
}
