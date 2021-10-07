package codegym.service;

import codegym.entity.Blog;
import codegym.entity.User;

import java.util.List;

public interface BlogService {
    Blog getBlog(int id);
    List<Blog> getListBlog();
    void deleteBlog(Blog blog);
    void saveOrEdit(Blog blog);
    List<Blog> getListBlogByName(String name);
}
