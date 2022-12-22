package com.example.controller;

import com.example.dto.NotificationDTO;
import com.example.service.NotificationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/notification/")
public class NotificationController {

    private final NotificationServiceImpl notificationService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<NotificationDTO> getAllNotifications() {
        return notificationService.getAllNotifications();
    }
}
