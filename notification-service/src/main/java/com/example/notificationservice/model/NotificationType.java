package com.example.notificationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("notification_types")
public class NotificationType {

    @Id
    private Long id;
    private String name;

    public NotificationType() {}

    public NotificationType(String name) {
        this.name = name;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}