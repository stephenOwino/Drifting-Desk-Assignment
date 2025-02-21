package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
public class ProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public ProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String publishMessage(@RequestBody String message) {
        kafkaTemplate.send("my-topic", message);
        return "Message published";
    }
}
