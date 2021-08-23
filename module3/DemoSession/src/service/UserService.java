package service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static List<User> userList;
    static {
        userList = new ArrayList<>();
        userList.add(new User("Linh", "123456"));
        userList.add(new User("Thanh", "123456"));
    }

    public User getUserByName(String name) {
        return userList.stream().filter(user -> name.equals(user.getUsername())).findAny().orElse(null);
    }
}
