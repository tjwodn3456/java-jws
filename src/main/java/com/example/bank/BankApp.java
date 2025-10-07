package com.example.bank;

import java.util.List;

public class BankApp {
    private static final int MENU_DEPOSIT = 1; // 상수를 이용한 Magic Number 기피
    private static final int MENU_WITHDRAW = 2;
    private static final int MENU_GET_BALANCE = 3;
    private static final int MENU_NEW_ACCOUNT = 4;
    private static final int MENU_NEW_SAVING_ACCOUNT = 5;
    private static final int MENU_CHECK_ACCOUNT_INTEREST_RATE = 6;
    private static final int MENU_STAFF_ONLY = 7;
    private static final int MENU_EXIT = 8;
    private static final int MENU_INTEREST_RATE_CHANGE = 9;
    private static final int MENU_ADJUST_BALANCE = 10;
    private static final int MENU_STAFF_EXIT = 11;

    BankService service = new BankService();
    BankView view = new BankView();

    // 메서드 : 메뉴 실행
    public void runMenu() {

        while (true) {
            int menu = 0;
            view.printMainMenu();
            String input = view.inputMenuNumber();
            if (service.checkMenuNumber(input) == 0) {
                view.printIncorrectInput();
                break;
            } else {
                menu = Integer.parseInt(input);
            }
            switch (menu) {
                case MENU_DEPOSIT:
                    new DepositAction().execute();
                    break;
                case MENU_WITHDRAW:
                    new WithDrawAction().execute();
                    break;
                case MENU_GET_BALANCE:
                    new GetBalanceAction().execute();
                    break;
                case MENU_NEW_ACCOUNT:
                    new NewAccountAction().execute();
                    break;
                case MENU_NEW_SAVING_ACCOUNT:
                    new NewSavingAccountAction().execute();
                    break;
                case MENU_CHECK_ACCOUNT_INTEREST_RATE:
                    new CheckAccountInterestRate().execute();
                    break;
                case MENU_STAFF_ONLY:
                    setMenuStaffOnly();
                    break;
                case MENU_EXIT:
                    view.printExit();
                    return;
            }
        }
    }
    // 메서드 : STAFF ONLY
    private void setMenuStaffOnly() {
        int menu = 0;
        while (true) {
            view.displayStaffMenu();
            String input = view.inputMenuNumber();
            int staffPassword = view.askStaffPassword();
            if (service.checkStaffPassword(staffPassword)) {
                continue;
            } else {
                view.wrongStaffPassword();
                break;
            }
            //if (service.checkMenuNumber(input) == 0) {
            //    view.printIncorrectInput();
            //    break;
            //} else {
            //    menu = Integer.parseInt(input);
            }
            switch (menu) {
                case MENU_INTEREST_RATE_CHANGE:
                    String targetUser = view.askAccountUserName();
                    Account targetAccount = service.directAccessAccount(targetUser);
                    BankService.InterestInfoDTO dto =service.getInterestInfo(targetUser);
                    view.displayInterestInfo(dto);
                    double changeInterestRate = view.askChangeInterestRate();
                    service.adjustInterestRate(targetAccount, changeInterestRate);
                    break;
                case MENU_ADJUST_BALANCE:
                    service.totallyAdjustBalance();
                    break;
                case MENU_STAFF_EXIT:
                    view.printReturnMenu();
                    return;
                }
            }
            private class DepositAction {
                private void execute() {
                    String depositName = view.askAccountUserName();
                    if (service.isNameExists(depositName)) {
                        int userPassword = view.askPssword();
                        Account account = service.findAccount(depositName, userPassword);
                        if (account != null) {
                            long deposit = view.askDepositAmount();
                            service.deposit(account, deposit);
                        }
                    } else {
                        view.printNoPassword();
                    }
                }
            }
            private class WithDrawAction {
                private void execute() {
                    String withdrawName = view.askAccountUserName();
                    if (service.isNameExists(withdrawName)) {
                        int userPassword = view.askPssword();
                        Account account = service.findAccount(withdrawName, userPassword);
                        if (account != null) {
                            long withdraw = view.askWithdrawAmount();
                            service.withdraw(account, withdraw);
                        }
                    } else {
                        view.printNoPassword();
                    }
                }
            }
            private class GetBalanceAction{
                private void execute(){
                    String getBalanceName = view.askAccountUserName();
                    if (service.isNameExists(getBalanceName)) {
                        int userPassword = view.askPssword();
                        Account account = service.findAccount(getBalanceName, userPassword);
                        if (account != null) {
                            view.printBalance(account);
                        }
                    } else {
                        view.printNoAccount();
                    }
                }
            }
            private class NewAccountAction{
                private void execute(){
                    String newName = view.askName();
                    if (service.isNameExists(newName)) {
                        view.printStackName();
                    }
                    int newPassword = view.askPssword();
                    long newBalance = view.askbalance();
                    service.createNewAccount(newName, newPassword, newBalance);
                    view.printRegistSuccess();
                }
            }
            private class NewSavingAccountAction{
                private void execute() {
                    String savingName;
                    while (true) {
                        savingName = view.askName();
                        if (service.isNameExists(savingName)) {
                            view.printStackName();
                            continue;
                        }
                        break;
                    }
                    int newSavingPassword = view.askPssword();
                    long newSavingBalance = view.askbalance();
                    SavingType savingProduct;
                    CreditTier creditTier;
                    while (true) {
                        view.printSavingProductList(SavingType.getSavingProducts());
                        String selectProduct = view.askProductName();
                        savingProduct = SavingType.fromString(selectProduct);
                        if (savingProduct != null) {
                            break;
                        }
                        view.printNoProduct();
                    }
                    while (true) {
                        String selectCreditTier = view.askCreditTier();
                        creditTier = CreditTier.fromString(selectCreditTier);
                        if (creditTier != null) {
                            break;
                        }
                        view.printNoCreditTier();
                    }
                    service.createNewSavingAccount(savingName, newSavingPassword, newSavingBalance, savingProduct, creditTier);
                    view.printRegistSuccess();
                }
            }
            private class CheckAccountInterestRate{
                private void execute(){
                    String checkInterestName = view.askAccountUserName();
                    if (service.isNameExists(checkInterestName)) {
                        int userPassword = view.askPssword();
                        Account account = service.findAccount(checkInterestName, userPassword);
                        if (account != null) {
                            BankService.InterestInfoDTO dto = service.getInterestInfo(checkInterestName, userPassword);
                            view.displayInterestInfo(dto);
                        }
                    } else {
                        view.printNoPassword();
                    }
                }
            }

    }



