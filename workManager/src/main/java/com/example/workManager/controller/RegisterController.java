package com.example.workManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.workManager.model.User;
import com.example.workManager.service.UserService;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView registerForm() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", new User());
        mav.setViewName("register");
        return mav;
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        User existing = userService.findByUsername(user.getUsername());
        if(existing == null){
            return "index";
        }
        userService.save(user);
        return "login";
    }
}
