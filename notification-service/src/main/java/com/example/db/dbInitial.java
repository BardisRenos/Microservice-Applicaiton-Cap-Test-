package com.example.db;

import com.example.dao.NotificationRepository;
import com.example.entity.Notification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class dbInitial {

    @Bean
    public CommandLineRunner initDB(NotificationRepository notificationRepository) {

        return args -> {

            Notification notification = new Notification(1, 5, 50, LocalDateTime.now());

            notificationRepository.save(notification);

        };
    }
}
