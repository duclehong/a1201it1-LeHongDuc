package com.codegym.Controller;


import com.codegym.model.Coin;
import com.codegym.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CoinController {
    @Autowired
    CoinService coinService;

    @GetMapping("/coin-list")
    public String showList(Pageable pageable, Model model){
        Page<Coin> coins = coinService.findAll(pageable);
        model.addAttribute("coins", coins);
        return "coin/list";
    }
    @GetMapping("/coin-create")
    public String showCreate(Model model){
        model.addAttribute("coin", new Coin());
        return "coin/create";
    }
    @PostMapping("coin-create")
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
    @GetMapping("/coin-edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        Coin coin = coinService.findById(id);
        model.addAttribute("coin", coin);
        return "coin/edit";
    }
    @PostMapping("/coin-edit")
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
    @GetMapping("coin-delete/{id}")
    public String showDelete(@PathVariable int id, Model model){
        Coin coin = coinService.findById(id);
        model.addAttribute("coin", coin);
        return "coin/delete";
    }
    @PostMapping("coin-delete")
    public String delete(@ModelAttribute("coin") Coin coin , Model model, RedirectAttributes redirectAttributes){
        coinService.delete(coin.getId());
        redirectAttributes.addFlashAttribute("xoaok", "okexoa");
        return "redirect:/";
    }
}
