package com.arilab.expman.controllers;

import com.arilab.expman.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {


    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }


    @GetMapping("/profile")
    public String profile() {
        return "auth/profile";
    }


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "auth/register";
    }
}
