package com.example.paymentservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("payments")
public class Payment {

    @Id
    private Long id;
    private BigDecimal amount;
    private Long orderId;
    private Long statusId;

    public Payment() {}

    public Payment(BigDecimal amount, Long orderId, Long statusId) {
        this.amount = amount;
        this.orderId = orderId;
        this.statusId = statusId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public Long getStatusId() { return statusId; }
    public void setStatusId(Long statusId) { this.statusId = statusId; }
}