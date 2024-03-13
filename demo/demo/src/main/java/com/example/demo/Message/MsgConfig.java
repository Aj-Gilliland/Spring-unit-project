package com.example.demo.Message;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import java.time.*;
import java.util.List;

@Configuration
public class MsgConfig {
    @Bean
    CommandLineRunner commandLineRunnerMsg(MsgRepository msgRepository){
        return args -> {
            Message Billy = new Message(
                    "Does anyone remember the time of that important meeting?",
                    LocalDate.of(2024, Month.JANUARY, 19),
                    "It should be around 2:00pm"
            );

            Message Bob = new Message(
                    "It should be around 2:00pm",
                    LocalDate.of(2024, Month.JANUARY, 19),
                    "Thank you so much bob"
            );

            msgRepository.saveAll(List.of(Billy,Bob));
        };
    }
}
