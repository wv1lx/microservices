package com.example.notificationservice.controller;

import com.example.notificationservice.model.NotificationType;
import com.example.notificationservice.service.NotificationTypeService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/types")
public class NotificationTypeController {

    private final NotificationTypeService typeService;

    public NotificationTypeController(NotificationTypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public Flux<NotificationType> getAllTypes() {
        return typeService.getAllTypes();
    }

    @GetMapping("/{id}")
    public Mono<NotificationType> getTypeById(@PathVariable Long id) {
        return typeService.getTypeById(id);
    }
}