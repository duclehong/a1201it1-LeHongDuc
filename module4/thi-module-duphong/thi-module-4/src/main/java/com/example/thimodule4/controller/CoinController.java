package com.example.thimodule4.controller;

import com.example.thimodule4.model.Coin;
import com.example.thimodule4.service.CoinService;
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
public class CoinController {
    @Autowired
    CoinService coinService;

    @GetMapping("/")
    public String showList(@RequestParam("s") Optional<String> s, Model model, @PageableDefault(value = 5) Pageable pageable){
        Page<Coin> coins ;
        if (s.isPresent()){
            coins = coinService.findAllByNameContaining(s.get(), pageable);
        }else {
            coins = coinService.findAll(pageable);
        }
        model.addAttribute("coins", coins);
        return "coin/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("coin", new Coin());
        return "coin/create";
    }
    @PostMapping("create")
    public String create(@Validated @ModelAttribute("coin") Coin coin , BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "coin/create";
        }else {
            coinService.save(coin);
            redirectAttributes.addFlashAttribute("createok", "nhập ngu");
            model.addAttribute("coin", coin);
            return "redirect:/";
        }
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        Coin coin = coinService.findById(id);
        model.addAttribute("coin", coin);
        return "coin/edit";
    }
    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("coin") Coin coin , BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "coin/edit";
        }else {
            coinService.save(coin);
            redirectAttributes.addFlashAttribute("editok", "nhập dark");
            model.addAttribute("coin", coin);
            return "redirect:/";
        }
    }
    @GetMapping("delete/{id}")
    public String showDelete(@PathVariable int id, Model model){
        Coin coin = coinService.findById(id);
        model.addAttribute("coin", coin);
        return "coin/delete";
    }
//    @PostMapping("delete")
//    public String delete(@ModelAttribute("coin") Coin coin , Model model, RedirectAttributes redirectAttributes){
//        coinService.delete(coin.getId());
//        redirectAttributes.addFlashAttribute("xoaok", "okexoa");
//        return "redirect:/";
//    }
@PostMapping("delete")
private String delete(@RequestParam(name = "idCoin") int id) {
    System.out.println(id);
    coinService.delete(id);
    return "redirect:/";
}
}
