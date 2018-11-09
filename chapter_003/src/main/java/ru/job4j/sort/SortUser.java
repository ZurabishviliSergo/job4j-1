package ru.job4j.sort;

import java.util.*;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/7/18
 */
public class SortUser {
    public Set<User> sort (List<User> users) {
        return new TreeSet<>(users);
    }
    public List<User> sortNameLength (List<User> users) {
        class UserCompareByNameLength implements Comparator<User> {
            public int compare(User lhs, User rhs) {
                int result = 0;
                if (lhs.getName().length() != rhs.getName().length()) {
                    result = lhs.getName().length() > rhs.getName().length() ? 1 : -1;
                }
                return result;
            }
        }
        UserCompareByNameLength userCompareByNameLength = new UserCompareByNameLength();
        Collections.sort(users, userCompareByNameLength);
        return users;
    }
    public List<User> sortByAllFields (List<User> users) {
        class UserCompareByAllFields implements Comparator<User> {
            public int compare(User lhs, User rhs) {
                int result = lhs.getName().compareTo(rhs.getName());
                if (result == 0) {
                    result = lhs.getAge() > rhs.getAge() ? 1 : -1;
                }
                return result;
            }
        }
        UserCompareByAllFields userCompareByAllFields = new UserCompareByAllFields();
        Collections.sort(users, userCompareByAllFields);
        return users;
    }
}
