package com.example.demo.Chatroom;

import com.example.demo.Message.Message;
import com.example.demo.Message.MessageRepository;
import com.example.demo.User.User;
import com.example.demo.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class ChatroomService {
    private final UserRepository userRepository;
    private final ChatroomRepository chatroomRepository;
    private final MessageRepository messageRepository;
    @Autowired
    public ChatroomService(UserRepository userRepository, ChatroomRepository chatroomRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.chatroomRepository = chatroomRepository;
        this.messageRepository = messageRepository;
    }
    public List<Chatroom> getAll() { return chatroomRepository.findAll(); }
    public void insertChatroom(Chatroom chatroom) { chatroomRepository.save(chatroom); }
//
    public void addMessage(Long chatroomId, Long messageId) {
        Chatroom chatroom = chatroomRepository.findById(chatroomId).orElseThrow(()-> new IllegalStateException("Chatroom #"+chatroomId+" doesn't exist!"));
        Message message = messageRepository.findById(messageId).orElseThrow(()-> new IllegalStateException("Message #"+messageId+" doesn't exist!"));
        chatroom.getMessages_in_the_chatroom().add(message);
        messageRepository.save(message);
        chatroomRepository.save(chatroom);
    }
}
