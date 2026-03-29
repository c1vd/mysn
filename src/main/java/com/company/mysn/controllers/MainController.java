package com.company.mysn.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.company.mysn.dto.RegistrationDto;
import com.company.mysn.services.ArticleService;
import com.company.mysn.services.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class MainController {
    @Autowired
    private ArticleService articleService;


    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String indexGet(Model model) {
        var randNum = new Random().nextInt(100000, 999999);
        model.addAttribute("title", String.valueOf(randNum));
        model.addAttribute("articles", articleService.last100());
        return "index";
    }

    @GetMapping("/login")
    public String loginGet(@RequestParam(required = false) boolean registered) {
        return "login";
    }
    
    @GetMapping("/register")
    public String registerGet(Model model) {
        model.addAttribute("registrationDto", new RegistrationDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("registrationDto") RegistrationDto dto, Model model) {
        var error = userService.register(dto);

        if (error != null){
            model.addAttribute("error", error);
            return "register";
        }

        return "redirect:/login?registered";
    }
}
