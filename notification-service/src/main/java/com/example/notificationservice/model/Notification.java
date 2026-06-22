package com.example.notificationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("notifications")
public class Notification {

    @Id
    private Long id;
    private String message;
    private Long userId;
    private Long typeId;

    public Notification() {}

    public Notification(String message, Long userId, Long typeId) {
        this.message = message;
        this.userId = userId;
        this.typeId = typeId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getTypeId() { return typeId; }
    public void setTypeId(Long typeId) { this.typeId = typeId; }
}