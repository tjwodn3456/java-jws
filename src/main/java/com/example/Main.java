package com.example;

public class Main {
    static void main(String[] args) {
        Child child = new Child();
        Parent parent = new Parent();

        child.methodA();
        System.out.println();
        parent.methodA();

        System.out.println();
        parent = new Child();
        System.out.println(parent.value);
        System.out.println();
        parent.methodA();

        System.out.println();
        System.out.println(parent);
        parent = child;

        System.out.println(parent);
        System.out.println(child);

    }
}
