package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/10/18
 */
public class Bank {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        this.getUserAccounts(passport).add(account);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        this.getUserAccounts(passport).remove(account);
    }

    public List<Account> getUserAccounts(String passport) {
        return this.users.get(new User("", passport));
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        List<Account> srcAccounts = this.getUserAccounts(srcPassport);
        List<Account> destAccounts = this.getUserAccounts(destPassport);
        Account srcAccount = srcAccounts.get(srcAccounts.indexOf(new Account(0, srcRequisite)));
        Account destAccount = destAccounts.get(destAccounts.indexOf(new Account(0, destRequisite)));
        return srcAccount != null && destAccount != null && srcAccount.transfer(destAccount, amount);
    }
}
