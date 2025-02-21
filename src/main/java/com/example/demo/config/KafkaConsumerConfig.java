package com.example.demo.config;

import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class KafkaConsumerConfig {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    @KafkaListener(topics = "my-topic")
    public void listen(String message) {
        try {
            // Log the received message
            logger.info("Received message: {}", message);

            // Process the message
            processMessage(message);

        } catch (Exception ex) {
            // Log the exception and handle it
            logger.error("Error while processing message: {}", message, ex);
        }
    }

    private void processMessage(String message) {
        // Validate the message
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty or null");
        }
        // Custom processing logic goes here
    }
}


