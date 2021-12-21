package com.example.task5.controller;

import com.example.task5.domain.User;
import com.example.task5.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepository.findByUsername(auth.getName());
        Date date = new Date();
        user.setDateLogin(date.toString());
        userRepository.save(user);
        Iterable<User> users = userRepository.findAll();
        model.put("users", users);
        return "main";
    }

}
