package com.example.clip4;

import com.example.clip4.model.Animal;
import com.example.clip4.producer.ClipProducer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Clip4Application {

    public static void main(String[] args) {
        SpringApplication.run(Clip4Application.class, args);
    }

    @Bean
    public ApplicationRunner runner (ClipProducer clipProducer) {
        return args -> {
            clipProducer.async("clip4-listener", "Hello, Clip4 listener.");
            clipProducer.async("clip4-animal", new Animal("puppy", 3));
        };
    }

    /*@Bean
    public ApplicationRunner runner (ClipProducer clipProducer,
                                     KafkaMessageListenerContainer<String, String> kafkaMessageListenerContainer) {
        return args -> {
            clipProducer.async("clip4", "Hello, Clip4 Container.");

            kafkaMessageListenerContainer.start();
            Thread.sleep(1_000L);

            System.out.println("-- pause --");
            kafkaMessageListenerContainer.pause();
            Thread.sleep(5_000L);

            clipProducer.async("clip4", "Hello, Secondly Clip4 Container.");

            System.out.println("-- resume --");
            kafkaMessageListenerContainer.resume();
            Thread.sleep(5_000L);

            System.out.println("-- stop --");
            kafkaMessageListenerContainer.stop();
        };
    }*/
}
