package com.example.demo.Message;

import com.example.demo.Chatroom.Chatroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() { return messageRepository.findAll(); }
}
