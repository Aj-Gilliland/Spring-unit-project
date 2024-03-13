package com.example.demo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

}
