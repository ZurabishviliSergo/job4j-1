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
        return this.users.get(this.findUserByPassport(passport));
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        Account srcAccount = this.findAccount(srcPassport, srcRequisite);
        Account destAccount = this.findAccount(destPassport, destRequisite);
        return srcAccount != null && destAccount != null && srcAccount.transfer(destAccount, amount);
    }
    private Account findAccount(String passport, String req) {
        Account result = null;
        for (Account account : this.getUserAccounts(passport)) {
            if (account.getRequisites().equals(req)) {
                result = account;
            }
        }
        return result;
    }

    private User findUserByPassport(String passport) {
        User result = null;
        for (User user : this.users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }
}
