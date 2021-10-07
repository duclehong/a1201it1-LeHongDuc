package codegym.repository.iml;

import codegym.entity.Blog;
import codegym.entity.User;
import codegym.repository.BlogRespository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public class BlogResositoryImpl implements BlogRespository {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Blog getBlog(int id) {
        return sessionFactory.getCurrentSession().get(Blog.class, id);
    }

    @Override
    public List<Blog> getListBlog() {
        return null;
    }

    @Override
    public void saveBlog(Blog blog) {

    }

    @Override
    public void editUBlog(Blog blog) {

    }

    @Override
    public void deleteBlog(Blog blog) {

    }

    @Override
    public void saveOrEdit(Blog blog) {

    }

    @Override
    public List<Blog> getListBlogrByName(String name) {
        return null;
    }
}
