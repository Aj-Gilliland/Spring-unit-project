package com.example.demo.Chatroom;

import com.example.demo.Message.Message;
import com.example.demo.User.User;
import jakarta.persistence.*;
import lombok.Data;
import java.util.*;

import java.util.HashSet;

@Data
@Entity
@Table
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
    @ManyToMany(mappedBy = "chatrooms")
    private Set<User> users = new HashSet<>();//defines all the users in the chatroom
    @ManyToMany
    @JoinTable(
            name = "messages_in_chatroom",
            joinColumns = @JoinColumn(name = "message_id"),
            inverseJoinColumns = @JoinColumn(name = "chatroom_id")
    )
    private Set<Message> messages_in_the_chatroom = new HashSet<>();//the chat room message history

    public Chatroom() {

    }
}
