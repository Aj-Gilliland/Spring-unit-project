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
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(
            name = "message_id",
            referencedColumnName = "id"
    )
    private User user;
    private String content;
    private LocalDate postDate;
    private String reply;

    public Message() {

    }
}
