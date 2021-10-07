package codegym.service.iml;

import codegym.entity.Blog;
import codegym.entity.User;
import codegym.repository.BlogRespository;
import codegym.repository.UserRepository;
import codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRespository blogRepository;
    @Override
    public Blog getBlog(int id) {
        return blogRepository.getBlog(id);
    }

    @Override
    public List<Blog> getListBlog() {
        return blogRepository.getListBlog();
    }

    @Override
    public void deleteBlog(Blog blog) {
        blogRepository.deleteBlog(blog);
    }

    @Override
    public void saveOrEdit(Blog blog) {
        blogRepository.saveOrEdit(blog);
    }

    @Override
    public List<Blog> getListBlogByName(String name) {
        return blogRepository.getListBlog();
    }
}
