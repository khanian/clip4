package com.example.clip4.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class ClipConsumer {

    @KafkaListener(id = "clip4-listener-id", topics = "clip4-listener", concurrency = "2", clientIdPrefix = "listener-id")
    public void listen(String message) {
        System.out.println("consume listener. message=" + message);
    }

}
