package com.example.event;

import com.example.response.Notification;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationEvent {

    private Integer accountId;
    private String status;
    private Notification notification;
}
