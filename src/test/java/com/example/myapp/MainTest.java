package com.example.myapp;

import com.example.bank.SavingType;
import org.junit.jupiter.api.Test;
import com.example.bank.BankView;
import com.example.bank.BankService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void testGetGreeting() {
        Main main = new Main();
        assertEquals("Hello, Gradle Kotlin DSL!", main.getGreeting());
    }

    @Test
    void testCalculator() {
        Main main = new Main();
        assertEquals(7, main.calculator(3,5));
    }


}
