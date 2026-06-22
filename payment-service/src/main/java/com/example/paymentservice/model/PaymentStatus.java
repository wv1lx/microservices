package com.example.paymentservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("payment_statuses")
public class PaymentStatus {

    @Id
    private Long id;
    private String name;

    public PaymentStatus() {}

    public PaymentStatus(String name) {
        this.name = name;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}