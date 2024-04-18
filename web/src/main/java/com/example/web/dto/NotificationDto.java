package com.example.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {

    private Long id;

    private String text;

    private String exchange;

    private String routingKey;

    private LocalDateTime createdAt;

    private Boolean isRead;
}
