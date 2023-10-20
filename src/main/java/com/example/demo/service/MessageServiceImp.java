package com.example.demo.service;

import com.example.demo.model.MessageUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MessageServiceImp extends JpaRepository<MessageUser, String> {
    List<MessageUser> findByName(String name);

}
