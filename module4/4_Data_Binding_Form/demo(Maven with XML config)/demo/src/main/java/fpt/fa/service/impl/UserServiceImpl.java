package fpt.fa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.fa.entities.User;
import fpt.fa.respository.UserDao;
import fpt.fa.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public void save(User user) {
		userDao.save(user);
	}

	public List<User> list() {
		return userDao.list();
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(name);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

}
