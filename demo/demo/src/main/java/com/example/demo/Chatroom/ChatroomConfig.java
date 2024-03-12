package com.example.demo.Chatroom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatroomConfig {
    @Bean
    CommandLineRunner ChatroomCommandLineRunner(ChatroomRepository crr) {
        return args -> {
            Chatroom test = new Chatroom(

            );
        };
    }
}
