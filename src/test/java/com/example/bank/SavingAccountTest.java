package com.example.bank;

import org.junit.jupiter.api.Test;

class SavingAccountTest {

    @Test
    void 계좌_생성_테스트() {
        SavingAccount account = new SavingAccount("홍길동", 1234, 10000, 0.05);
        assertEquals("홍길동", account.getUserName());
        assertEquals(10000, account.getBalance());
    }

    @Test
    void 이자_추가_테스트() {
        SavingAccount account = new SavingAccount("홍길동", 1234, 10000, 0.1);
        account.addInterest();
        assertEquals(11000, account.getBalance());
    }

   // @Test
   // void 이자_예외_테스트() {
   //     assertThrows();
   // }
}