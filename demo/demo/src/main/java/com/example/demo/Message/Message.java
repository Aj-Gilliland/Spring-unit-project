package com.example.demo.Message;

import com.example.demo.User.User;
import jakarta.persistence.*;
import jakarta.persistence.SequenceGenerator;

import java.time.LocalDate;
import java.util.*;


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

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPostDate() {
        return postDate;
    }
    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getReply() {
        return reply;
    }
    public void setReply(String reply) {
        this.reply = reply;
    }

    @Override
    public String toString(){
        return "Club{"+
                "id=" + id +
                ", content=" + content + '\'' +
                ", postDate="+postDate + '\'' +
                ", reply="+reply+ '\'' +
                "}";
    }

}
