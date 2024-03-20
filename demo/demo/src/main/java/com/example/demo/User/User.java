package com.example.demo.User;

import com.example.demo.Chatroom.Chatroom;
import com.example.demo.Message.Message;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;

@Entity
@Data
@EqualsAndHashCode(exclude = {"chatrooms","messages"})
@Table(name = "\"user\"")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String fName;//first name
    private String lName;//last name
    private String email;//email
    private Boolean admin;// checks if user is an admin
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "user_chatrooms",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "chatroom_id")
    )
    private Set<Chatroom> chatrooms = new HashSet<>();//all chatrooms the user is in
    @OneToMany(mappedBy = "user" ,cascade = CascadeType.REMOVE)
    private Set<Message> messages = new HashSet<>();//all messages owned by a user(history)

    public User() {
    }

    public User(Long id, String fName, String lName, String email, Boolean admin, Set<Chatroom> chatrooms, Set<Message> messages) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.admin = admin;
        this.chatrooms = chatrooms;
        this.messages = messages;
    }

    public User(String fName, String lName, String email, Boolean admin, Set<Chatroom> chatrooms, Set<Message> messages) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.admin = admin;
        this.chatrooms = chatrooms;
        this.messages = messages;
    }

    public User(String fName, String lName, String email, Boolean admin) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.admin = admin;
    }

    public User(Long id, String fName, String lName, String email, Boolean admin) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.admin = admin;
    }
}
