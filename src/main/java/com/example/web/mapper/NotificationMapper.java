package com.example.web.mapper;

import com.example.commonlib.mapper.MapperService;
import com.example.web.dto.NotificationDto;
import com.example.web.entity.Notification;
import org.mapstruct.Mapper;

@Mapper
public interface NotificationMapper extends MapperService<Notification, NotificationDto> {

}
