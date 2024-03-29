package com.example.demo.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner UserCommandLineRunner(UserRepository repository) {
        return args -> {
            User testUser = new User(
                    //empty instance
            );
            repository.save(testUser);
        };
    }
}

