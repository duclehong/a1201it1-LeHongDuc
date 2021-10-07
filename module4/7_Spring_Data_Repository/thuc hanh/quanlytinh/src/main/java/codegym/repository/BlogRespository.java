package codegym.repository;

import codegym.entity.Blog;
import codegym.entity.User;

import java.util.List;

public interface BlogRespository {
    Blog getBlog(int id);
    List<Blog> getListBlog();
    void saveBlog(Blog blog);
    void editUBlog(Blog blog);
    void deleteBlog(Blog blog);
    void saveOrEdit(Blog blog);
    List<Blog> getListBlogrByName(String name);
}
