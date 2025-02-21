package com.example.demo.config;

import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class KafkaConsumerConfig {

    @KafkaListener(topics = "my-topic")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
