package codegym.repository.iml;

import codegym.entity.User;
import codegym.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Transactional
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> getListUser() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void editUser(User user) {
        sessionFactory.getCurrentSession().update(user);

    }

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().remove(user);
    }

    @Override
    public void saveOrEdit(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public List<User> getListUserByName(String name) {
        return null;
    }

    @Override
    public List<User> getListUserByAge(int age) {
        return null;
    }
}

