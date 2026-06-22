package com.example.notificationservice.repository;

import com.example.notificationservice.model.NotificationType;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface NotificationTypeRepository extends ReactiveCrudRepository<NotificationType, Long> {
}