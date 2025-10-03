package com.example;

public class Child extends Parent {
    String value = "Child";


    public void methodA() {
        System.out.println("Child");
        System.out.println("Value : " + value);
    }
}