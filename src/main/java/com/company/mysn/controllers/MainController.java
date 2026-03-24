package com.company.mysn.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
    @GetMapping("/")
    public String indexPage(Model model) {
        var randNum = new Random().nextInt(100000, 999999);
        model.addAttribute("title", String.valueOf(randNum));
        return "index";
    }
}
