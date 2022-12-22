package com.example.service;

import com.example.dao.NotificationRepository;
import com.example.dto.NotificationDTO;
import com.example.entity.Notification;
import com.example.mapper.NotificationMapper;
import com.example.service.Interfaces.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public List<NotificationDTO> getAllNotifications() {
        return notificationRepository.findAll().stream().map(NotificationMapper::toNotificationDTO).collect(Collectors.toList());
    }

    @Override
    public Notification addNotification(Notification transaction) {
        return notificationRepository.save(transaction);
    }
}
