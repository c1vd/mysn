package com.company.mysn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("title", "WebPage");
        return "index";
    }
}
