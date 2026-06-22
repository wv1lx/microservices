package com.example.paymentservice.service;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Flux<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Mono<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public Flux<Payment> getPaymentsByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

    public Flux<Payment> getPaymentsByStatus(Long statusId) {
        return paymentRepository.findByStatusId(statusId);
    }

    public Mono<Payment> createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}