package ru.job4j.map;


import org.junit.Test;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenUserInListThenMapWithUserKey() {
        UserConvert uc = new UserConvert();
        List<User> list = new ArrayList<>();
        User user = new User(1, "Ivan", "Moscow");
        list.add(new User(1, "Ivan", "Moscow"));
        HashMap<Integer, User> result = uc.process(list);
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(1, user);
        assertThat(result, is(expected));
    }
}
