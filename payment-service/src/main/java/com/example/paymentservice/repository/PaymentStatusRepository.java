package com.example.paymentservice.repository;

import com.example.paymentservice.model.PaymentStatus;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PaymentStatusRepository extends ReactiveCrudRepository<PaymentStatus, Long> {
}