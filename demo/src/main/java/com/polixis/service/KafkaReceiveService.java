package com.polixis.service;

import com.polixis.model.entity.KafkaMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaReceiveService {

    private static final String TOPIC = "topic-name";

    @Autowired
    private KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    public void sendMessage(KafkaMessage message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
