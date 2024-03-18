package com.example.demo.Message;

import com.example.demo.Chatroom.Chatroom;
import com.example.demo.User.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.*;

@Data
@EqualsAndHashCode(exclude = {"chatrooms","user"})
@Entity
@Table
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Message {
    @Id
    @SequenceGenerator(
            name = "msg_sequence",
            sequenceName = "msg_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "msg_sequence"
    )
    private Long id;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private User user;//the person who owns the message
    private String content;//content of message
    private LocalDate postDate;
    @ManyToMany
    @JoinTable(//this is not broken DO NOT TOUCH
            name = "message_thread",
            joinColumns = @JoinColumn(name = "message_id"),
            inverseJoinColumns = @JoinColumn(name = "reply_id")
    )
    private Set<Message> replies = new HashSet<>();//the actual message that is being replied with
    @ManyToMany(mappedBy = "messages")
    private Set<Chatroom> chatrooms = new HashSet<>();//links message to a chatroom

    public Message() {
    }

    public Message(Long id, User user, String content, LocalDate postDate, Set<Message> replies, Set<Chatroom> chatrooms) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.postDate = postDate;
        this.replies = replies;
        this.chatrooms = chatrooms;
    }

    public Message(User user, String content, LocalDate postDate, Set<Message> replies, Set<Chatroom> chatrooms) {
        this.user = user;
        this.content = content;
        this.postDate = postDate;
        this.replies = replies;
        this.chatrooms = chatrooms;
    }

    public Message(User user, String content, LocalDate postDate) {
        this.user = user;
        this.content = content;
        this.postDate = postDate;
    }

    public Message(Long id, User user, String content, LocalDate postDate) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.postDate = postDate;
    }
}
