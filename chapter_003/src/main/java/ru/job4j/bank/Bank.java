package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
        Stream<Account> accountStream = this.getUserAccounts(passport).stream();
        return accountStream.filter(acc -> acc.getRequisites().equals(req)).findFirst().orElse(null);
    }

    private User findUserByPassport(String passport) {
        Stream<User> userStream = this.users.keySet().stream();
        return userStream.filter(user -> user.getPassport().equals(passport)).findFirst().orElse(null);
    }
}
