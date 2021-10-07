package fpt.fa.respository;

import java.util.List;

import fpt.fa.entities.User;

public interface UserDao {
    void save(User user);
    List<User> list();
    User getUserByName(String name);
    void update(User user);
 }
