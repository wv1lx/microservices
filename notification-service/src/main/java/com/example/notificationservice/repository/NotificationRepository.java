package com.example.notificationservice.repository;

import com.example.notificationservice.model.Notification;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface NotificationRepository extends ReactiveCrudRepository<Notification, Long> {
    Flux<Notification> findByUserId(Long userId);
    Flux<Notification> findByTypeId(Long typeId);
}