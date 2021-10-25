package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CounterController {


    @GetMapping("/")
    public String get() {
        return "index";
    }
}