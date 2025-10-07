package com.example.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAppTest {
    class FakeBankView extends BankView {
        private final String[] script;
        private int scriptIndex = 0;

        public FakeBankView(String[] script) {
            this.script = script;
        }

        private String getNextLineFromScript() {
            if (scriptIndex < script.length) {
                return script[scriptIndex++];
            }
            return "";
        }

        @Override
        public String inputMenuNumber() {
            return getNextLineFromScript();
        }

        @Override
        public String askAccountUserName() {
            return getNextLineFromScript();
        }

        @Override
        public int askPssword() {
            return Integer.parseInt(getNextLineFromScript());
        }

        @Override
        public long askWithdrawAmount() {
            return Long.parseLong(getNextLineFromScript());
        }
    }

        @Test
        void withdrawAction_should_decrease_balance_correctly() {
            BankService service = new BankService();
            service.createNewAccount("testUser", 1234, 10000L);

            String[] withdrawScript = {"2", "testUser", "1234", "3000", "8"};
            BankView fakeView = new BankAppTest.FakeBankView(withdrawScript);
            BankApp bankApp = new BankApp(service, fakeView);
            bankApp.runMenu();

            Account account = service.directAccessAccount("testUser");
            assertEquals(7000L, account.getBalance());

        }
}

