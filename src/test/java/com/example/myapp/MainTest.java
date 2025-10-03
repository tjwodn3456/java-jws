package com.example.myapp;

import org.junit.jupiter.api.Test;
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
