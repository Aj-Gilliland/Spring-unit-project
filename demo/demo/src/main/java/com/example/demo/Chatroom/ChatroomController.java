package com.example.demo.Chatroom;

import com.example.demo.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/chatrooms")
public class ChatroomController {
    @Autowired
    private ChatroomService crs;

    @GetMapping("/getAll")//get all chat rooms
    public List<Chatroom> getAll() { return crs.getAll(); }

    @PostMapping//make a chat room
    @GetMapping("/makeChatroom")
    public void createChatroom(@RequestBody Chatroom chatroom) { crs.insertChatroom(chatroom); }

    @PutMapping(path =  "/addConversation/{chatroomId}/{messageId}")//add a message chat room
    public void addMessage(
            @PathVariable("chatroomId") Long chatroomId,
            @PathVariable("messageId") Long messageId){
        crs.addConversion(chatroomId, messageId);
    }
    @GetMapping("/getChatroom")
    public Chatroom getChatroom(Long chatroomId) {
        return crs.getChatroom(chatroomId);
    }
    @DeleteMapping("/deleteChatroom")
    public void deleteChatroom(Long deleteChatroom){
        crs.deleteChatroom(deleteChatroom);
    }

}
