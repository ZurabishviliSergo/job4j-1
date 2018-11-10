package ru.job4j.bank;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/10/18
 */
public class BankTest {
    @Test
    public void whenAddUserThenNoAccounts() {
        Bank bank = new Bank();
        bank.addUser(new User("Test Name", "TestPass"));
        assertThat(bank.getUserAccounts("TestPass").size(), is(0));
    }
    @Test
    public void whenAddAndDeleteUserThenNoAccounts() {
        Bank bank = new Bank();
        User user = new User("Test Name", "TestPass");
        bank.addUser(user);
        bank.deleteUser(user);
        assertThat(bank.getUserAccounts("TestPass"), is(nullValue()));
    }
    @Test
    public void whenAddAccountThenAccountsSizeIsOne() {
        Bank bank = new Bank();
        bank.addUser(new User("Test Name", "TestPass"));
        bank.addAccountToUser("TestPass", new Account(100, "RU001"));
        assertThat(bank.getUserAccounts("TestPass").size(), is(1));
    }
    @Test
    public void whenAddAndDeleteAccountThenAccountsSizeIs0() {
        Bank bank = new Bank();
        bank.addUser(new User("Test Name", "TestPass"));
        Account account = new Account(100, "RU001");
        bank.addAccountToUser("TestPass", account);
        bank.deleteAccountFromUser("TestPass", account);
        assertThat(bank.getUserAccounts("TestPass").size(), is(0));
    }
    @Test
    public void whenTransferThenNewValue() {
        Bank bank = new Bank();
        bank.addUser(new User("Test Name", "TestPass"));
        bank.addUser(new User("Test Name", "TestPass2"));
        Account account = new Account(100, "RU001");
        Account account2 = new Account(100, "RU002");
        bank.addAccountToUser("TestPass", account);
        bank.addAccountToUser("TestPass2", account2);
        bank.transferMoney("TestPass", "RU001", "TestPass2", "RU002", 100);
        List<Account> destUserAccounts = bank.getUserAccounts("TestPass2");
        assertThat(destUserAccounts.get(destUserAccounts.indexOf(account2)).getValue(), is(200.0));
    }
}
