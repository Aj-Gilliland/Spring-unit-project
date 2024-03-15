package com.example.demo.Message;

<<<<<<< HEAD
import com.example.demo.Chatroom.Chatroom;
=======
import com.example.demo.Chatroom.ChatroomRepository;
import com.example.demo.User.User;
import com.example.demo.User.UserRepository;
import jakarta.transaction.Transactional;
>>>>>>> refs/remotes/origin/main
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
<<<<<<< HEAD

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() { return messageRepository.findAll(); }
=======
@Service
public class MessageService {
    private final UserRepository userRepository;
    private final ChatroomRepository chatroomRepository;
    private final MessageRepository messageRepository;
    @Autowired
    public MessageService(UserRepository userRepository, ChatroomRepository chatroomRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.chatroomRepository = chatroomRepository;
        this.messageRepository = messageRepository;
    }
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@//
    public List<Message> getAll() { return messageRepository.findAll(); }
    public void insertMessage(Message message) { messageRepository.save(message); }
    public void addReply(Long messageId, Long replyId) {
        Message message = messageRepository.findById(messageId).orElseThrow(()-> new IllegalStateException("Message #"+messageId+" doesn't exist!"));
        Message reply = messageRepository.findById(replyId).orElseThrow(()-> new IllegalStateException("Reply #"+replyId+" doesn't exist!"));
        message.getReplies().add(reply);
        messageRepository.save(message);
    }

    @Transactional
    public void addMessageToUser(Long messageId,Long userId){
        Message message = messageRepository.findById(messageId).orElseThrow(()-> new IllegalStateException("Message #"+messageId+" doesn't exist!"));
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalStateException("User #"+userId+" doesn't exist!"));
        user.getMessages().add(message);
        message.setUser(user);
        userRepository.save(user);
        messageRepository.save(message);
    }
>>>>>>> refs/remotes/origin/main
}
