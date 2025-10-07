package com.example.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;


public class BankService {
    private ArrayList<Account> accounts = new ArrayList<>();


    // 메서드 : 신규 계좌 , 이름을 입력 받으려 할때 숫자가 섞이는 경우는 어떻게 하지?
    public void createNewAccount(String name, int password, long balance) {
        Account account = new Account(name, password, balance);
        accounts.add(account);
    }


    // 메서드 : 신규 적금 계좌
    public void createNewSavingAccount(String name, int password, long balance, SavingType savingType, CreditTier creditTier) {
        SavingAccount account = new SavingAccount(name, password, balance, savingType, creditTier);
        accounts.add(account);
    }

    // 계좌를 찾아주는 보조 메서드(Helper Method)
    public Account findAccount(String name, int password) {
        for (Account account : accounts) {
            if (account.getUserName().equals(name)) {
                if (account.isPasswordCorrect(password)) {
                    return account; // 계좌를 찾아서 반환!
                }
            }
        }
        return null; // 못 찾았으면 null 반환
    }
    // 계좌를 찾아주는 보조 메서드(Helper Method)
    public Account directAccessAccount(String name) {
        for (Account account : accounts) {
            if (account.getUserName().equals(name)) {
                    return account; // 계좌를 찾아서 반환!
                }
            } return null; // 못 찾았으면 null 반환
        }

    // 통합(Saving, Loan) 상품 목록 찾기
    public List<Product> getAllProducts(){
        List<Product> allProducts = new ArrayList<>();
        allProducts.addAll(Arrays.asList(SavingType.values()));
        allProducts.addAll(Arrays.asList(LoanType.values()));
        return allProducts;
    }


    // 메서드 : 입금 하기
    public void deposit(Account account, long amount) {
        Account account1 = findAccount(account.userName, account.password);
        account.deposit(amount); // 해당 계좌 객체에게 입금을 '위임'한다
    }

    // 메서드 : 출금 하기
    public void withdraw(Account account, long amount) {
        Account account1 = findAccount(account.userName, account.password);
        account.withdraw(amount); // 해당 계좌 객체에게 출금을 '위임'한다
    }

    // 메서드 : 잔액 계산
    public long checkBalance(Account account) {
        return account.getBalance();
    }

    // 메서드 : 사용자 중복 확인
    public boolean isNameExists(String name) {
        for (Account account : accounts) {
            if (account.getUserName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    // 적금 계좌 List 출력
    public void listSavingAccounts() {
        System.out.println("--- 전체 적금 계좌 목록 ---");
        boolean found = false;
        for (Account account : accounts) {
            if (account instanceof SavingAccount) {
                SavingAccount sa = (SavingAccount) account;
                System.out.println("예금주: " + sa.getUserName() + ", 잔액: " + sa.getBalance() + ", 이자율: " + sa.getInterestRate());
                found = true;
            }
        }
        if (!found) {
            System.out.println("등록된 적금 계좌가 없습니다.");
        }
        System.out.println("--------------------");
    }

    // 메서드 : 모든 계좌에 저축 이자 주기 or 대출 이자 차감
    public List<AdjustInterestDTO> totallyAdjustBalance() {
        List<AdjustInterestDTO> results = new ArrayList<>();
        for (Account account : accounts) {
            long beforeBalance = account.getBalance();
            account.adjustBalance();
            long afterBalance = account.getBalance();
            AdjustInterestDTO result = new AdjustInterestDTO(account, beforeBalance, afterBalance);
            results.add(result);
            }
        return results;
    }

    // 이자율 확인 후 반환 or 이자율 없음 판단
    public InterestInfoDTO getInterestInfo(String name, int password) {
        Account account = findAccount(name, password);
        if (account == null) {
            return null;
        }
        double rate = account.getInterestRate();
        boolean isApplicable = (rate != 0.0);
        return new InterestInfoDTO(isApplicable, rate);
    }

    // 관리자 버젼 이자율 확인 후 반환 or 이자율 없음 판단
    public InterestInfoDTO getInterestInfo(String name) {
        Account account = directAccessAccount(name);
        if (account == null) {
            return null;
        }
        double rate = account.getInterestRate();
        boolean isApplicable = (rate != 0.0);
        return new InterestInfoDTO(isApplicable, rate);
    }


    // 메서드 : 특정 고객 이자율 조정
    public double[] adjustInterestRate(Account account, double changeInterestRate) {
        double beforeRate = account.getInterestRate();
        account.adjustInterestRate(changeInterestRate);
        double afterRate = account.getInterestRate();
        return new double[]{beforeRate, afterRate};
    }

    // 관리자 비밀번호 확인
    public boolean checkStaffPassword(int staffPassword) {
        if (staffPassword == 1234) {
            return true;
        }
        return false;
    }

    // 메뉴 번호 확인, 잘못된 타입 입력  방지
    public int checkMenuNumber(String input) {
        int menu;
        try {
            menu = Integer.parseInt(input);
        } catch (InputMismatchException e) {
            menu = 0;
            return menu;
        }
        return menu;
    }

    public static class AdjustInterestDTO {
        private final Account account;  // 해당 account 객체
        private final long beforeBalance; // 해당 account 객체의 원금
        private final long afterBalance;

        public AdjustInterestDTO(Account account, long beforeBalance, long afterBalance) {
            this.account = account;
            this.beforeBalance = beforeBalance;
            this.afterBalance = afterBalance;
        }

        public Account getAccount(){
            return account;
        }

        public long getBeforeBalance(){
            return beforeBalance;
        }
        public long getAfterBalance(){
            return afterBalance;
        }
    }
    public static class InterestInfoDTO {
        private final boolean isApplicable; // 이자율 적용 대상 여부
        private final double interestRate;  // 이자율

        public InterestInfoDTO(boolean isApplicable, double interestRate) {
            this.isApplicable = isApplicable;
            this.interestRate = interestRate;
        }

        // View가 데이터를 꺼내 쓸 수 있도록 Getter 메서드를 열어둔다.
        public boolean isApplicable() {
            return isApplicable;
        }

        public double getInterestRate() {
            return interestRate;
        }
    }
}
