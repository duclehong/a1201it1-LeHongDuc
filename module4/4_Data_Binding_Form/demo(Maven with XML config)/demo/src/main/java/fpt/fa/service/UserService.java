package fpt.fa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fpt.fa.entities.User;

public interface UserService {
	void save(User user);
	List<User> list();
	User getUserByName(String name);
	void update(User user);
}
