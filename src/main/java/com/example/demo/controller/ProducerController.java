package com.example.demo.controller;

import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/publish")
public class ProducerController {

    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    //constructor injection
    public ProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String publishMessage(@RequestBody String message) {
        // Send message to Kafka topic asynchronously
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("my-topic", message);

        // Add callback for success and failure
        future.whenComplete((result, ex) -> {
            if (ex != null) {
                // Log failure details
                logger.error("Unable to deliver message [{}]. Error: {}", message, ex.getMessage());
            } else {
                // Log success details
                logger.info("Message [{}] delivered with offset {}", message, result.getRecordMetadata().offset());
            }
        });

        // Return immediately without blocking
        return "Message publishing initiated";
    }
}

