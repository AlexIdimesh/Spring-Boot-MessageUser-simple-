package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Table(name = "message")
@Entity
public class MessageUser {
    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "message_username")
    @Size(min = 1, max = 50)
    private String name;

    @Column(name = "message_message")
    @Size(max = 10000)
    private String message;

    public MessageUser() {
    }

    public MessageUser(String name, String message) {
        this.name = name;
        this.message = message;
    }
}
