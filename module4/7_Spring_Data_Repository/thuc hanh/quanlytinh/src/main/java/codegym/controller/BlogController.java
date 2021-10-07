package codegym.controller;

import codegym.entity.Blog;
import codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/index")
    public String index(@RequestParam(required = false) String nameSearch,
                        @RequestParam(required = false) String ageSearch, Model model) {
        List<Blog> blogs;
        if (nameSearch != null && !nameSearch.isEmpty()) {
            blogs = blogService.getListBlogByName(nameSearch);

        }  else {
            blogs = blogService.getListBlog();
        }

        model.addAttribute("blogs", blogs);
        model.addAttribute("blog1", "Linh");
        model.addAttribute("blog2", "Bao");
        return "blog/index";
    }

    @GetMapping("/create")
    public String displayCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("action", "create");
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog) {
        blogService.saveOrEdit(blog);
        return "redirect:/blog/index";
    }

    @GetMapping("/edit/{id}")
    public String displayEdit(@PathVariable int id ,Model model) {
        Blog blog = blogService.getBlog(id);
        model.addAttribute("blog", blog);
        model.addAttribute("action", "edit");
        return "blog/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        blogService.deleteBlog(blogService.getBlog(id));
        return "redirect:/blog/index";
    }

    @GetMapping("/detail/{id}")
    public String displayDetail(@PathVariable int id ,Model model) {
        Blog blog = blogService.getBlog(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }
}
