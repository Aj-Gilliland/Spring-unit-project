package com.example.demo.Chatroom;

import com.example.demo.Message.Message;
import com.example.demo.User.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;

import java.util.HashSet;

@Data
@EqualsAndHashCode(exclude = {"users","messages"})
@Entity
@Table
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Chatroom {
    @Id
    @SequenceGenerator(
            name = "chatroom_sequence",
            sequenceName = "chatroom_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chatroom_sequence")
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "chatrooms", cascade = CascadeType.REMOVE)
    private Set<User> users = new HashSet<>();//defines all the users in the chatroom
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "messages_in_chatroom",
            joinColumns = @JoinColumn(name = "chatroom_id"),
            inverseJoinColumns = @JoinColumn(name = "message_id")
    )
    private Set<Message> messages = new HashSet<>();//the chat room message history

    public Chatroom() {
    }

    public Chatroom(Long id, String name, Set<User> users, Set<Message> messages) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.messages = messages;
    }

    public Chatroom(String name, Set<User> users, Set<Message> messages) {
        this.name = name;
        this.users = users;
        this.messages = messages;
    }

    public Chatroom(String name) {
        this.name = name;
    }

    public Chatroom(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
