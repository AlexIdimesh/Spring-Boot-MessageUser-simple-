package com.example.demo.service;

import com.example.demo.model.MessageUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Collections;
import java.util.List;

@Service
public class MessageService {
    private final MessageServiceImp messageRepository;

    @Autowired
    public MessageService(MessageServiceImp messageRepository) {
        this.messageRepository = messageRepository;
    }

    public MessageUser addAllMessage(MessageUser messageUser) {
        return messageRepository.save(messageUser);
    }

    public List<MessageUser> getAllMessage() {
        return messageRepository.findAll();
    }

    public List<MessageUser> findByTag(String name) {
        return messageRepository.findByName(name);
    }

    public boolean saveUser(MessageUser user) {
        MessageUser messageUser = (MessageUser) messageRepository.findByName(user.getName());
        if (messageUser != null) {
            return false;
        }
        user.setName(String.valueOf(new MessageUser()));
        messageRepository.save(user);
        return true;
    }
}

