package com.example.orderservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("order_statuses")
public class OrderStatus {

    @Id
    private Long id;
    private String name;

    public OrderStatus() {}

    public OrderStatus(String name) {
        this.name = name;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}