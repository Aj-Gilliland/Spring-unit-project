package com.example.demo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/getAll")
    public List<Message> getAll() { return messageService.getAll(); }
    @PostMapping
    public void createMessage(@RequestBody Message message) { messageService.insertMessage(message); }

}
