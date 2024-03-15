package com.example.demo.Message;

<<<<<<< HEAD
import com.example.demo.Chatroom.Chatroom;
import com.example.demo.Chatroom.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
>>>>>>> refs/remotes/origin/main

import java.util.List;

@RestController
@RequestMapping(path="/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

<<<<<<< HEAD
    @GetMapping("/messages")
    public List<Message> getAll() { return messageService.getAll(); }
=======
    @GetMapping("/getAll")//get all messages
    public List<Message> getAll() { return messageService.getAll(); }

    @PostMapping//make a message
    @GetMapping("/makeMessage")
    public void createMessage(@RequestBody Message message) { messageService.insertMessage(message); }
    @PutMapping(path = "/addMessageToUser/{messageId}/{userId}")//add a message to the users list of total messages
    public void addMessageToUser(
            @PathVariable("messageId") Long messageId,
            @PathVariable("userId") Long userId){
        messageService.addMessageToUser(messageId,userId);
    }
    @PutMapping(path = "/addReply/{messageId}/{replyId}")//add a message reply
    public void addReply(
            @PathVariable("messageId") Long messageId,
            @PathVariable("replyId") Long replyId){
        messageService.addReply(messageId,replyId);
    }

>>>>>>> refs/remotes/origin/main
}


