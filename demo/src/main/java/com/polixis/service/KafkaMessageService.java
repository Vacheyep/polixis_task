package com.polixis.service;

import com.polixis.model.entity.KafkaMessage;
import org.springframework.stereotype.Service;
import com.polixis.repository.KafkaMessageRepo;

import java.util.Optional;

@Service
public class KafkaMessageService {

    final KafkaMessageRepo kafkaMessageRepo;

    public KafkaMessageService(KafkaMessageRepo kafkaMessageRepo) {
        this.kafkaMessageRepo = kafkaMessageRepo;
    }

    public KafkaMessage saveMessage(String messageContent) {
        KafkaMessage kafkaMessage = new KafkaMessage();
        kafkaMessage.setMessage(messageContent);
        return kafkaMessageRepo.save(kafkaMessage);
    }

    public Optional<KafkaMessage> findById(Long messageId){
        return kafkaMessageRepo.findById(messageId);
    }
}
