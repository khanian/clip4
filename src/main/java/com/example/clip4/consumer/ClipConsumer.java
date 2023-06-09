package com.example.clip4.consumer;

import com.example.clip4.model.Animal;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;

@Service
public class ClipConsumer {

    @KafkaListener(id = "clip4-listener-id", topics = "clip4-listener", concurrency= "2", clientIdPrefix = "listener-id")
    public void listen(String message,
                       @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp,
                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                       @Header(KafkaHeaders.OFFSET) long offset,
                       ConsumerRecordMetadata metadata) {
        System.out.println("consume listener. meta.timestamp="+ metadata.timestamp() + " type=" + metadata.timestampType());
        System.out.println("consume listener. meta.offset="+ metadata.offset() + " message=" + message);
        System.out.println("consume listener. offset="+ offset
                + " partition=" + partition
                + " timestamp=" + new Date(timestamp)
                + " message=" + message
        );
    }

    @KafkaListener(id = "clip4-animal-listener-id", topics = "clip4-animal", containerFactory ="kafkaJsonContainerFactory")
    public void listenAnimal(@Valid Animal animal) {
        System.out.println("Animal. animal=" + animal);
    }

}
