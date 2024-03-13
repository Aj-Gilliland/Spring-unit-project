package com.example.demo.User;

import com.example.demo.Message.MessageRepository;
import com.example.demo.Chatroom.ChatroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ChatroomRepository chatroomRepository;
    private final MessageRepository messageRepository;
    @Autowired
    public UserService(UserRepository userRepository, ChatroomRepository chatroomRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.chatroomRepository = chatroomRepository;
        this.messageRepository = messageRepository;
    }

    public List<User> getAll() { return userRepository.findAll(); }

    public void insertUser(User user) { userRepository.save(user); }
}
