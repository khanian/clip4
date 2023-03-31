package com.example.clip4.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.time.chrono.ChronoLocalDate;
import java.util.Date;

@Service
public class ClipConsumer {

    @KafkaListener(id = "clip4-listener-id", topics = "clip4-listener")
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

}
