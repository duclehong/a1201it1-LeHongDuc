package codegym.repository.iml;

import codegym.entity.Blog;
import codegym.entity.User;
import codegym.repository.BlogRespository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class BlogRespositoryImpl2 implements BlogRespository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Blog getBlog(int id) {
        return entityManager.find(Blog.class, id);
    }

    @Override
    public List<Blog> getListBlog() {
        TypedQuery<Blog> query = entityManager.createQuery("select u from Blog u", Blog.class);
        return query.getResultList();
    }

    @Override
    public void saveBlog(Blog Blog) {
        entityManager.persist(Blog);
    }

    @Override
    public void editUBlog(Blog Blog) {
        entityManager.merge(Blog);
    }

    @Override
    public void deleteBlog(Blog user) {
        entityManager.remove(user);
    }

    @Override
    public void saveOrEdit(Blog blog) {
        if (blog.getId() == 0) {
            entityManager.persist(blog);
        } else {
            entityManager.merge(blog);
        }
    }

    @Override
    public List<Blog> getListBlogrByName(String name) {
        // HSQL != query
        return entityManager.createQuery("select u from Blog u where u.name like :name", Blog.class)
                .setParameter("name", "%"+ name + "%")
                .getResultList();
    }


}
