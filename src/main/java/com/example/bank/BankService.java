package com.example.bank;

import java.util.ArrayList;
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
    public void createNewSavingAccount(String name, int password, long balance, double interestRate) {
        SavingAccount account = new SavingAccount(name, password, balance, interestRate);
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
    public List<AdjustBalaneInfoDTO> totallyAdjustBalance() {
        List<AdjustBalaneInfoDTO> results = new ArrayList<>();
        for (Account account : accounts) {
            if (account instanceof AccountUtility) {
                AccountUtility utility = (AccountUtility) account;
                long beforeBalance = account.balance;
                utility.adjustBalance();
                AdjustBalaneInfoDTO result = new AdjustBalaneInfoDTO(account, beforeBalance);
                results.add(result);
            }
        }
        return results;
    }

    // 이자율 확인 후 반환 or 이자율 없음 판단
    public InterestInfoDTO getInterestInfo(String name, int password) {
        Account account = findAccount(name, password);

        if (account == null) {
            // 계좌가 없다는 정보도 DTO로 표현할 수 있지만, 지금은 간단히 null로 처리하자.
            return null;
        }
        if (account instanceof AccountUtility) {
            AccountUtility utility = (AccountUtility) account;
            // 적용 대상이고, 이자율이 얼마인지 DTO에 담아 반환
            return new InterestInfoDTO(true, utility.getInterestRate());
        } else {
            // 적용 대상이 아니라는 정보를 DTO에 담아 반환
            return new InterestInfoDTO(false, 0.0);
        }
    }
    // 관리자 버젼 이자율 확인 후 반환 or 이자율 없음 판단
    public InterestInfoDTO getInterestInfo(String name) {
        Account account = directAccessAccount(name);

        if (account == null) {
            // 계좌가 없다는 정보도 DTO로 표현할 수 있지만, 지금은 간단히 null로 처리하자.
            return null;
        }
        if (account instanceof AccountUtility) {
            AccountUtility utility = (AccountUtility) account;
            // 적용 대상이고, 이자율이 얼마인지 DTO에 담아 반환
            return new InterestInfoDTO(true, utility.getInterestRate());
        } else {
            // 적용 대상이 아니라는 정보를 DTO에 담아 반환
            return new InterestInfoDTO(false, 0.0);
        }
    }

    // 메서드 : 특정 고객 이자율 조정
    public double[] adjustInterestRate(Account account, double changeInterestRate) {
        if (account instanceof AccountUtility) {
            AccountUtility utility = (AccountUtility) account;
            double beforeinterestRate = utility.getInterestRate();
            utility.adjustInterestRate(changeInterestRate);
            double afterInterestRate = utility.getInterestRate();
            return new double[]{beforeinterestRate, afterInterestRate};
        }
        return null;
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


}
