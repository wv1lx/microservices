package com.example.paymentservice.controller;

import com.example.paymentservice.model.PaymentStatus;
import com.example.paymentservice.service.PaymentStatusService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/statuses")
public class PaymentStatusController {

    private final PaymentStatusService statusService;

    public PaymentStatusController(PaymentStatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public Flux<PaymentStatus> getAllStatuses() {
        return statusService.getAllStatuses();
    }

    @GetMapping("/{id}")
    public Mono<PaymentStatus> getStatusById(@PathVariable Long id) {
        return statusService.getStatusById(id);
    }
}