package com.example.bank;

import java.util.Arrays;
import java.util.List;

public enum SavingType implements Product{
    YOUTH_HOPE_SAVINGS(5.0, 15.5),
    ;

    // 최대, 최소 이율
    private final double minRate;
    private final double maxRate;

    // 생성자
    private SavingType(double minRate, double maxRate) {
        this.minRate = minRate;
        this.maxRate = maxRate;
    }

    // Saving 상품 목록 찾기
    public static List<SavingType> getSavingProducts(){
        return Arrays.asList(SavingType.values());
    }


    // 사용자 입력 값이 일치하면 enum 타입으로 변환
    public static SavingType fromString(String input){
        List<SavingType> savingTypes = getSavingProducts();
        for (SavingType type : savingTypes) {
            if (type.name().equals(input)) {
                return type;
                }
            }
            return null;
        }


    //Getter
    public double getMinRate() {
        return this.minRate;
    }
    public double getMaxRate() {
        return this.maxRate;
    }
}
