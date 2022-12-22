package com.example.service.Interfaces;

import com.example.dto.NotificationDTO;
import com.example.entity.Notification;

import java.util.List;

public interface NotificationService {

    public List<NotificationDTO> getAllNotifications();

    Notification addNotification(Notification transaction);
}
