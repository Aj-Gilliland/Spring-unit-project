package com.example.demo.User;

import com.example.demo.Chatroom.Chatroom;
import com.example.demo.Message.Message;
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

    public void addUserToChatroom(Long userId, Long chatroomId) {
        Chatroom chatroom = chatroomRepository.findById(chatroomId).orElseThrow(()-> new IllegalStateException("Chatroom #"+chatroomId+" doesn't exist!"));
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalStateException("User #"+userId+" doesn't exist!"));
        chatroom.getUsers().add(user);
        user.getChatrooms().add(chatroom);
        userRepository.save(user);
        chatroomRepository.save(chatroom);
    }
    public User getUser(Long userId){
        return userRepository.findById(userId).orElseThrow(()-> new IllegalStateException("User #"+userId+" doesn't exist!"));
    }
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }
}
