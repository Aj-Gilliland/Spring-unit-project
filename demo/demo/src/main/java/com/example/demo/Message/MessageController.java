package com.example.demo.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/Messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/message")
    public List<Message> getAll() { return messageService.getAll(); }
}
