package com.example.thimodule4.controller;

import com.example.thimodule4.model.Coin;
import com.example.thimodule4.model.Question;
import com.example.thimodule4.model.QuestionType;
import com.example.thimodule4.service.QuestionService;
import com.example.thimodule4.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;
@Controller
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @Autowired
    private QuestionTypeService questionTypeService;

    @ModelAttribute("questionType")
    public Iterable<QuestionType> questionTypes() {
        return questionTypeService.findAll();
    }
    @GetMapping("/")
    public String showList(@RequestParam("s") Optional<String> s, Model model, @PageableDefault(value = 5) Pageable pageable){
        Page<Question> questions ;
        if (s.isPresent()){
            questions = questionService.findAllByTitleContaining(s.get(), pageable);
        }else {
            questions = questionService.findAll(pageable);
        }
        model.addAttribute("questions", questions);
        return "question/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("question", new Question());
        return "question/create";
    }
    @PostMapping("create")
    public String create(@Validated @ModelAttribute("question") Question question , BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "question/create";
        }else {
            questionService.save(question);
            redirectAttributes.addFlashAttribute("createok", "createok");
            model.addAttribute("question", question);
            return "redirect:/";
        }
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        Question question = questionService.findById(id);
        model.addAttribute("question", question);
        return "question/edit";
    }
    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("question") Question question , BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "question/edit";
        }else {
            questionService.save(question);
            redirectAttributes.addFlashAttribute("editok", "editok");
            model.addAttribute("question", question);
            return "redirect:/";
        }
    }
//    @GetMapping("delete/{id}")
//    public String showDelete(@PathVariable int id, Model model){
//        Question question = questionService.findById(id);
//        model.addAttribute("question", question);
//        return "question/delete";
//    }
//    @PostMapping("delete")
//    private String delete(@RequestParam(name = "idQuestion") int id) {
//        System.out.println(id);
//        questionService.delete(id);
//        return "redirect:/";
//    }
@GetMapping("delete/{id}")
public String showDelete(@PathVariable int id, Model model){
    Question question = questionService.findById(id);
    model.addAttribute("question", question);
    return "question/delete";
}
    @PostMapping("delete")
    public String delete(@ModelAttribute("coin") Question question , Model model, RedirectAttributes redirectAttributes){
        questionService.delete(question.getId());
        redirectAttributes.addFlashAttribute("xoaok", "okexoa");
        return "redirect:/";
    }
}
