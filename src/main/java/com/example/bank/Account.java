package com.example.bank;

public class Account extends AccountData {

    // 생성자, 초기 잔액 미 입력 시 계좌 생성 불가
    public Account(String userName, int password, long balance) {
        this.userName = userName;
        this.password = password;
        this.balance = balance;
    }
    // 메서드 : 입금, 0 보다 작을 수 없음
    public void deposit(long amount) {
        while (true) {
            if (amount < 0) {
                System.out.println("입금액은 0원 이상이여야 합니다. 다시 입력해주세요");
            } else {
                changeBalance(amount);
                System.out.println(amount + "원 입금이 완료되었습니다. 현재 잔액: " + this.balance);
                break;
            }
        }
    }
    // 메서드 : 출금, 0 보다 작을 수 없음, 잔액보다 클 수 없음
    public void withdraw(long amount) {
        while (true) {
            if (this.balance < amount || amount < 0) {
                System.out.println("입금액은 잔액을 초과하거나, 0원 작을 수 없습니다. 다시 입력하세요");
            } else {
                this.balance -= amount;
                System.out.println(amount + "원 출금이 완료되었습니다. 현재 잔액: " + this.balance);
            }
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", password=" + password +
                ", balance=" + balance +
                '}';
    }
}
