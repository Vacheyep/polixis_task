package com.polixis.repository;

import com.polixis.model.entity.KafkaMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface KafkaMessageRepo extends JpaRepository<KafkaMessage, Long> {
}
