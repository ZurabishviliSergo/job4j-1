package ru.job4j.bank;

import java.util.Objects;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/10/18
 */
public class Account {
    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }
    public boolean transfer(Account account, double amount) {
        boolean result = false;
        if (this.value >= amount && account != null) {
            this.value -= amount;
            account.credit(amount);
            result = true;
        }
        return result;
    }
    public void credit(double amount) {
        this.value += amount;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }
}
