package com.example.notificationservice.service;

import com.example.notificationservice.model.Notification;
import com.example.notificationservice.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Flux<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Mono<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    public Flux<Notification> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    public Flux<Notification> getNotificationsByType(Long typeId) {
        return notificationRepository.findByTypeId(typeId);
    }

    public Mono<Notification> createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }
}