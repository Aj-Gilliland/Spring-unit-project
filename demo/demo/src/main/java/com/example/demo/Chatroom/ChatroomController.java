package com.example.demo.Chatroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/chatroom")
public class ChatroomController {
    @Autowired
    private ChatroomService crs;

    @GetMapping("/rooms")
    public List<Chatroom> getAll() { return crs.getAll(); }
}
