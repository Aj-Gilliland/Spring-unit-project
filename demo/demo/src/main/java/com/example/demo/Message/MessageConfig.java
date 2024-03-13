package com.example.demo.Message;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import java.time.*;
import java.util.List;

@Configuration
public class MessageConfig {
    @Bean
    CommandLineRunner MessageCommandLineRunner(MessageRepository messageRepository){
        return args -> {
            Message Billy = new Message(
            );

            Message Bob = new Message(
            );

            messageRepository.saveAll(List.of(Billy,Bob));
        };
    }
}
