package com.example.mapper;

import com.example.dto.NotificationDTO;
import com.example.entity.Notification;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class NotificationMapper {

    public static NotificationDTO toNotificationDTO(Notification notification) {
        return new ModelMapper().map(notification, NotificationDTO.class);
    }

}
