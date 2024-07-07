package com.polixis.service;

import com.polixis.model.entity.KafkaMessage;
import com.polixis.repository.KafkaMessageRepo;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumeService {
    private final KafkaMessageRepo kafkaMessageRepo;

    public KafkaConsumeService(KafkaMessageRepo kafkaMessageRepo) {
        this.kafkaMessageRepo = kafkaMessageRepo;
    }

    @KafkaListener(topics = "topic-name", groupId = "group-name")
    public void consumeMessage(String message) {
        System.out.println("Received message from Kafka: " + message);
        kafkaMessageRepo.save(new KafkaMessage(message));
    }
}
