package com.example.springstart.controller;

import com.example.springstart.model.User;
import com.example.springstart.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User>users=userService.findAll();
        model.addAttribute("users",users);
        return "user-list";
    }
    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }
    @PostMapping
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

}
