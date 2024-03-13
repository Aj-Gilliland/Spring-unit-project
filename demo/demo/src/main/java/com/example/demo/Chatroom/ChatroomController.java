package com.example.demo.Chatroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/chatrooms")
public class ChatroomController {
    @Autowired
    private ChatroomService crs;

    @GetMapping("/getAll")
    public List<Chatroom> getAll() { return crs.getAll(); }

    @PostMapping
    public void createChatroom(@RequestBody Chatroom chatroom) { crs.insertChatroom(chatroom); }
}
