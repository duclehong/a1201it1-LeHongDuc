package fpt.fa.respository.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fpt.fa.entities.User;
import fpt.fa.respository.UserDao;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public List<User> list() {
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
		return query.getResultList();
	}

	@Override
	public User getUserByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		String query = "from User where username = :username";
		User user;
		user = (User)session.createQuery(query).setParameter("username", name).uniqueResult();
		return user;
	}

	@Override
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}
}
