package com.example.web.dto;

import com.example.commonlib.dto.FilterRequest;
import lombok.Data;

@Data
public class NotificationFilterDto implements FilterRequest {

    private Boolean isRead;
}
