package com.example.bank;

// 기본적인 Account Data 만 저장 및 해당 Data 접근
public abstract class AccountData {
    // 잔액, private 으로 외부에서 변경 불가
    // private 으로 잠궈버리니까 Product 처럼 해당 클래스에서 데이터만 가지고 있는게 불가능해졌어.
    protected String userName;
    protected int password;
    protected long balance;



    // 상속 접근 가능 메서드
    // 원금 조정
    protected void changeBalance(long amount) {
        this.balance += amount;
    }
    // 메서드 : 검증 메서드
    public long getBalance() {
        return this.balance;
    }
    // 계좌 소유주 이름 가져오기
    public String getUserName() {
        return this.userName;
    }
    // 계좌 비밀번호 맞는지 확인
    public boolean isPasswordCorrect(int password) {
        return this.password == password;
    }
}
