package com.example.paymentservice.repository;

import com.example.paymentservice.model.Payment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PaymentRepository extends ReactiveCrudRepository<Payment, Long> {
    Flux<Payment> findByOrderId(Long orderId);
    Flux<Payment> findByStatusId(Long statusId);
}