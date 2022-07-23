package com.manning.junitbook.ch08.account;

public interface AccountManager {
    Account findAccountForUser(String userId);
    void updateAccount(Account account);
}
