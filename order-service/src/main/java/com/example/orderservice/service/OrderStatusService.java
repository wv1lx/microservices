package com.example.orderservice.service;

import com.example.orderservice.model.OrderStatus;
import com.example.orderservice.repository.OrderStatusRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderStatusService {

    private final OrderStatusRepository statusRepository;
    private final ConcurrentHashMap<Long, OrderStatus> cache = new ConcurrentHashMap<>();

    public OrderStatusService(OrderStatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Flux<OrderStatus> getAllStatuses() {
        return statusRepository.findAll()
                .doOnNext(s -> cache.put(s.getId(), s));
    }

    public Mono<OrderStatus> getStatusById(Long id) {
        OrderStatus cached = cache.get(id);
        if (cached != null) {
            return Mono.just(cached);
        }
        return statusRepository.findById(id)
                .doOnNext(s -> cache.put(id, s));
    }
}