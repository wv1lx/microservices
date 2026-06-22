package com.example.paymentservice.service;

import com.example.paymentservice.model.PaymentStatus;
import com.example.paymentservice.repository.PaymentStatusRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class PaymentStatusService {

    private final PaymentStatusRepository statusRepository;
    private final ConcurrentHashMap<Long, PaymentStatus> cache = new ConcurrentHashMap<>();

    public PaymentStatusService(PaymentStatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Flux<PaymentStatus> getAllStatuses() {
        return statusRepository.findAll()
                .doOnNext(s -> cache.put(s.getId(), s));
    }

    public Mono<PaymentStatus> getStatusById(Long id) {
        PaymentStatus cached = cache.get(id);
        if (cached != null) {
            return Mono.just(cached);
        }
        return statusRepository.findById(id)
                .doOnNext(s -> cache.put(id, s));
    }
}