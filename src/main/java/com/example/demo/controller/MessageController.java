package com.example.demo.controller;

import com.example.demo.model.MessageUser;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Controller
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    //домашняя страница
    @GetMapping("/home")
    public String messageHomePage() {
        return "home";
    }

    //добавление сообщений и показ
    @PostMapping
    public String addMessage(@RequestParam String message, @RequestParam String name, Model model) {
        MessageUser messageUser = new MessageUser(message,name);
        messageService.addAllMessage(messageUser);

        List<MessageUser> messageUsers1 = messageService.getAllMessage();

        model.addAttribute("message", messageUsers1);
        return "redirect:/main";
    }

    //фильтр
    @PostMapping("filter")
    public String filter (@RequestParam String filter, Model model) {
        Iterable<MessageUser> messageUsers;

        if (filter != null || !filter.isEmpty()) {
            messageUsers = messageService.findByTag(filter);
        } else {
            messageUsers = messageService.getAllMessage();
        }
        model.addAttribute("message",messageUsers);
        return "redirect:/main";
    }
}
