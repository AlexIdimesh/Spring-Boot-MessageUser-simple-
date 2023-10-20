package com.example.demo.controller;

import com.example.demo.model.MessageUser;
import com.example.demo.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistationController {

    private final MessageService messageService;

    @Autowired
    public RegistationController(MessageService messageService) {
        this.messageService = messageService;
    }

    // регистарация
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userForm", new MessageUser());
        return "login";
    }

    @PostMapping("/login")
    public String addUser(@ModelAttribute("userForm") @Valid MessageUser user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "login";
        }
        if (!messageService.saveUser(user)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "login";
        }

        return "redirect:/main";
    }
}
