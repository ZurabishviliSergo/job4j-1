package ru.job4j.map;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
//        HashMap<Integer, User> result = new HashMap<>();
//        for (User user : list) {
//            result.put(user.getId(), user);
//        }
//        return result;
        return (HashMap<Integer, User>) list.stream().collect(Collectors
                .toMap(User::getId, user -> user));
    }
}
