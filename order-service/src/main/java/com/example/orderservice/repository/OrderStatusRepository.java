package com.example.orderservice.repository;

import com.example.orderservice.model.OrderStatus;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface OrderStatusRepository extends ReactiveCrudRepository<OrderStatus, Long> {
}