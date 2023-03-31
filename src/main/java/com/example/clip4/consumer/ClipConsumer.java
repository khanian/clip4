package com.example.clip4.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class ClipConsumer {

    @KafkaListener(id = "clip4-listener-id", topics = "clip4-listener")
    public void listen(String message,
                       ConsumerRecordMetadata metadata) {
        System.out.println("consume listener. timestamp="+ metadata.timestamp() + " type=" + metadata.timestampType());
        System.out.println("consume listener. offset="+ metadata.offset() + " message=" + message);
    }

}
