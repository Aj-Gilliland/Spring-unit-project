package com.example.demo.Chatroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class ChatroomService {
    @Autowired
    private ChatroomRepository crr;

    public List<Chatroom> getAll() { return crr.findAll(); }

    public void insertChatroom(Chatroom chatroom) { crr.save(chatroom); }
}
