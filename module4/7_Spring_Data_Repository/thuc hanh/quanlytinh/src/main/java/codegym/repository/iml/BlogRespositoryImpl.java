package codegym.repository.iml;

import codegym.entity.Blog;
import codegym.entity.User;
import codegym.repository.BlogRespository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;
@Transactional
public class BlogRespositoryImpl implements BlogRespository {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Blog getBlog(int id) {
        return sessionFactory.getCurrentSession().get(Blog.class, id);
    }

    @Override
    public List<Blog> getListBlog() {
        TypedQuery<Blog> query = sessionFactory.getCurrentSession().createQuery("from Blog");
        return query.getResultList();
    }

    @Override
    public void saveBlog(Blog blog) {
        Session session = sessionFactory.getCurrentSession();
        session.save(blog);
    }

    @Override
    public void editUBlog(Blog blog) {
        sessionFactory.getCurrentSession().update(blog);
    }

    @Override
    public void deleteBlog(Blog blog) {
        sessionFactory.getCurrentSession().remove(blog);
    }

    @Override
    public void saveOrEdit(Blog blog) {
        sessionFactory.getCurrentSession().saveOrUpdate(blog);
    }

    @Override
    public List<Blog> getListBlogrByName(String name) {
        return null;
    }
}
