package com.example.orderservice.controller;

import com.example.orderservice.model.OrderStatus;
import com.example.orderservice.service.OrderStatusService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/statuses")
public class OrderStatusController {

    private final OrderStatusService statusService;

    public OrderStatusController(OrderStatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public Flux<OrderStatus> getAllStatuses() {
        return statusService.getAllStatuses();
    }

    @GetMapping("/{id}")
    public Mono<OrderStatus> getStatusById(@PathVariable Long id) {
        return statusService.getStatusById(id);
    }
}