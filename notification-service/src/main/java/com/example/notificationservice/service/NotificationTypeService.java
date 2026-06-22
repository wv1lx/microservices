package com.example.notificationservice.service;

import com.example.notificationservice.model.NotificationType;
import com.example.notificationservice.repository.NotificationTypeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class NotificationTypeService {

    private final NotificationTypeRepository typeRepository;
    private final ConcurrentHashMap<Long, NotificationType> cache = new ConcurrentHashMap<>();

    public NotificationTypeService(NotificationTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Flux<NotificationType> getAllTypes() {
        return typeRepository.findAll()
                .doOnNext(t -> cache.put(t.getId(), t));
    }

    public Mono<NotificationType> getTypeById(Long id) {
        NotificationType cached = cache.get(id);
        if (cached != null) {
            return Mono.just(cached);
        }
        return typeRepository.findById(id)
                .doOnNext(t -> cache.put(id, t));
    }
}