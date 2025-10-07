package com.example.bank;

public class BankMain {
    static void main(String[] args) {
        BankService service = new BankService();
        BankView view = new BankView();
        BankApp bankApp = new BankApp(service, view);

        bankApp.runMenu();

    }
}
