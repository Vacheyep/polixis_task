package com.polixis.controller;

import com.polixis.model.entity.KafkaMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.polixis.service.KafkaMessageService;

import java.util.Optional;

@RestController
public class MessageController {

    private final KafkaMessageService kafkaMessageService;

    public MessageController(KafkaMessageService kafkaMessageService) {
        this.kafkaMessageService = kafkaMessageService;
    }

    @PostMapping("/messages")
    public KafkaMessage saveMessage(@RequestBody String message) {
        return kafkaMessageService.saveMessage(message);
    }

    @PostMapping("/kafka")
    public ResponseEntity<?> save(@RequestBody String message){
        KafkaMessage kafkaMessage = new KafkaMessage();
        kafkaMessage.setMessage(message);
        kafkaMessageService.saveMessage(message);
        return ResponseEntity.ok(message);
    }
    @GetMapping("/{id}")
    public ResponseEntity<KafkaMessage> getMessageById(@PathVariable Long id) {
        Optional<KafkaMessage> kafkaMessage = kafkaMessageService.findById(id);
        return kafkaMessage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
}
