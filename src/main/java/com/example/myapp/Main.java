package com.example.myapp;

public class Main {
    public String getGreeting() {
        return "Hello, Gradle Kotlin DSL!";
    }

    public int calculator(int a, int b) {
        return a + b;
    }


    public static void main(String[] args) {
        System.out.println(new Main().getGreeting());
    }
}
