package com.example.bank;

import java.util.List;
import java.util.Scanner;

public class BankView {
    Scanner scanner = new Scanner(System.in);


    // 초기 이름 설정
    public String askName() {
        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();
        return name;
    }

    // 사용자 중복 메시지 출력
    public void printStackName() {
        System.out.println("이미 존재하는 사용자 명 입니다.");
    }

    // 초기 비밀번호 설정
    public int askPssword() {
        System.out.print("비밀번호를 입력하세요: ");
        int password = scanner.nextInt();
        scanner.nextLine();
        return password;
    }

    // 초기 입금액 설정
    public long askbalance() {
        System.out.print("초기 입금액을 입력하세요: ");
        long balance = scanner.nextInt();
        scanner.nextLine();
        return balance;
    }

    // 초기 이자  설정
    public double askInterestRate() {
        System.out.print("이자율을 입력하세요: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        return amount;
    }

    // 초기 계좌 설정 완료 메시지
    public void printRegistSuccess() {
        System.out.println("계좌 등록이 완료 되었습니다.");
    }

    // 입금액 묻기
    public long askDepositAmount() {
        System.out.print("입금할 금액을 입력하세요: ");
        long amount = scanner.nextLong();
        scanner.nextLine();
        return amount;
    }

    // 출금액 묻기
    public long askWithdrawAmount() {
        System.out.print("출금할 금액을 입력하세요: ");
        long amount = scanner.nextLong();
        scanner.nextLine();
        return amount;
    }

    // 계좌 소유주명 묻기
    public String askAccountUserName() {
        System.out.print("계좌 소유주 이름을 입력하세요: ");
        String name = scanner.nextLine();
        return name;
    }

    // 잔액 출력
    public void printBalance(Account account) {
        System.out.println("현재 잔액은 " + account.balance + "원 입니다.");
    }

    // 틀린 비밀번호 출력 메세지
    public void printNoPassword() {
        System.out.println("계좌 비밀번호가 일치하지 않습니다.");
    }

    // 계좌 못찾았을때 출력 메세지
    public void printNoAccount() {
        System.out.println("계좌 정보가 일치하지 않습니다.");
    }

   /* // 저축 이자 or 대출 이자 차감 목록 메세지
    public void printAdjustAccountList(List<AdjustBalaneInfoDTO>results) {
        for (AdjustBalaneInfoDTO result : results) {
            String userName = result.getAccount().getUserName();
            long before = result.getBeforeBalance();
            System.out.println(userName + " 에게 이자 지급 or 차감 완료. 기존 잔액: " + before + " 원. 현재 잔액 " + account.balance + " 원.");
        }
    }   */


    public String[] askAccountCredentials() {
        System.out.print("계좌 소유주 이름을 입력하세요: ");
        String name = scanner.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.nextLine();
        return new String[]{name, password};
    }

    public void displayInterenstInfo(InterestInfoDTO dto) {
        if (dto == null) {
            System.out.println("계좌 정보가 일치하지 않습니다.");
            return;
        }

        if (dto.isApplicable()) {
            System.out.println("현재 이자율: " + dto.getInterestRate() + "%");
        } else {
            System.out.println("해당 계좌는 일반 계좌로, 이자율이 적용되지 않습니다.");
        }
    }

    // 이자율 변경 메세지
    public double askChangeInterestRate() {
        System.out.print("변경할 이자율을 입력하세요(숫자만): ");
        double changeInterestRate = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("이자율이 " + changeInterestRate + "% 로 변경되었습니다.");
        return changeInterestRate;
    }

    // 메뉴 보여주기
    public void printMainMenu() {
        System.out.println("+++은행 프로그램 시작+++");
        System.out.println("MENU | 1. 입금 | 2. 출금 | 3. 잔액 확인 | 4. 신규 일반 계좌 등록 | 5. 신규 적금 계좌 등록 | 6. 이율 확인 | 7.STAFF ONLY | 8. 종료");
        System.out.print("===메뉴를 선택해주세요===  :  ");
    }

    // 프로그램 종료 메시지
    public void printExit() {
        System.out.println("프로그램을 종료 합니다.");
    }

    //  묻기, 관리자 메뉴 비밀번호
    public int askStaffPassword() {
        int menu = 0;
        System.out.print("관리자 비밀번호를 입력하세요 : ");
        int staffPaswword = scanner.nextInt();
        scanner.nextLine();
        return staffPaswword;
    }

    //  틀림, 관리자 메뉴 비밀번호
    public void wrongStaffPassword() {
        System.out.println("관리자 비밀번호가 일치하지 않습니다.");
    }


    // Staff 메뉴 출력
    public void displayStaffMenu() {
        System.out.println("MENU | 9. 특정 고객 이자율 조정 | 10. 전체 고객 이자 지급 & 차감 | 11. exit ");
        System.out.print("===메뉴를 선택해주세요===  :  ");
    }

    // 사용자 입력 값 받기, String 으로
    public String inputMenuNumber() {
        return scanner.nextLine();
    }


    public void printIncorrectInput() {
        System.out.println("잘 못된 입력 입니다. 다시 입력해 주세요.");
    }


    // 일반 메뉴로 돌아가는 메세지
    public void printReturnMenu() {
        System.out.println("일반 MENU로 되돌아 갑니다.");
    }
}
