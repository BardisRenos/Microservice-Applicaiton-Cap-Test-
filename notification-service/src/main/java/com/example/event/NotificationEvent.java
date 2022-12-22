package com.example.event;

import com.example.entity.Notification;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationEvent {

    private Integer accountId;
    private String status;
    private Notification notification;
}
