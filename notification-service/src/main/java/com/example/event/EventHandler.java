package com.example.event;

import com.example.entity.Notification;
import com.example.service.Interfaces.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventHandler {

    public static final String QUEUE = "notification_queue";

    private final NotificationService notificationService;

    public EventHandler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = QUEUE)
    public void handleCustomerEvent(final NotificationEvent notificationEvent) {
        log.info("A notification event received the account of: {}", notificationEvent.getAccountId());
        try {
            if (notificationEvent.getStatus().equals("CREATED")) {
                Notification transaction = notificationEvent.getNotification();

                log.info("Write a Notification entity into database table");
                notificationService.addNotification(transaction);
            }
        } catch (Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }

}
