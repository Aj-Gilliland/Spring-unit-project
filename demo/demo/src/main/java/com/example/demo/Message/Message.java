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
@EqualsAndHashCode(exclude = {"chatrooms"})
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

}
