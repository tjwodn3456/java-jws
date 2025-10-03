package com.example.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void testAdd() {
        assertEquals(8, Calculator.add(4, 4));
    }
    @Test
    void testSubtract() {
        assertEquals(0, Calculator.subtract(4, 4));
    }
    @Test
    void testMultiply() {
        assertEquals(16, Calculator.multiply(4, 4));
    }
    @Test
    void testDivide() {
        assertEquals(1, Calculator.divide(4, 4));
    }

    @Test
    @DisplayName("0으로 나눌 때 ArithmeticException이 발생해야 하며, 메시지도 확인")
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            Calculator.divide(4, 0);
        });
        assertEquals("0으로 나눌 수 없습니다.", exception.getMessage());
    }
}
