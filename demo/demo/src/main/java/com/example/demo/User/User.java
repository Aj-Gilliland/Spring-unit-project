package com.example.demo.User;

import com.example.demo.Chatroom.Chatroom;
import com.example.demo.Message.Message;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;

@Entity
@Data
@EqualsAndHashCode(exclude = {"chatrooms"})
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
    private long id;
    private String fName;//first name
    private String lName;//last name
    private String email;//email
    @ManyToMany
    @JoinTable(
            name = "user_chatrooms",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "chatroom_id")
    )
    private Set<Chatroom> chatrooms = new HashSet<>();//all chatrooms the user is in
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Message> messages = new HashSet<>();//all messages owned by a user(history)

    public User() {
    }

}
