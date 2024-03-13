package com.example.demo.Message;

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

    private Set<User> users = new HashSet<>();

    private String content;
    private LocalDate postDate;

    private String reply;

    public Message(Long id,
//                   Set<User> users,
                   String content,
                   LocalDate postDate,
                   String reply) {
        this.id = id;
//        this.users = users;
        this.content = content;
        this.postDate = postDate;
        this.reply = reply;
    }

    public Message( //Set<User> users,
                   String content,
                   LocalDate postDate,
                   String reply) {
//        this.users = users;
        this.content = content;
        this.postDate = postDate;
        this.reply = reply;
    }
}
