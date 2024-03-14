package com.example.demo.Message;

import com.example.demo.Chatroom.Chatroom;
import com.example.demo.User.User;
import jakarta.persistence.*;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

import java.time.LocalDate;
import java.util.*;

@Data
@Entity
@Table
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
//    @ManyToMany(mappedBy = "user_messages")
//    private Set<User> users = new HashSet<>();//links all messages to the user history
    @ManyToMany(mappedBy = "messages_in_the_chatroom")
    private Set<Chatroom> chatroom_message = new HashSet<>();//links message to a chatroom

    public Message() {

    }

}
