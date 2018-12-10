package ru.job4j.map;


import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenUserInListThenMapWithUserKey() {
        UserConvert uc = new UserConvert();
        HashMap<Integer, User> result = uc.process(List.of(new User(1, "Ivan", "Moscow")));
        Map<Integer, User> expected = Map.of(1, new User(1, "Ivan", "Moscow"));
        assertThat(result, is(expected));
    }
}
