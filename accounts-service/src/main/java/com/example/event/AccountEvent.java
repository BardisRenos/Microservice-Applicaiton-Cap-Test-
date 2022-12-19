package com.example.event;

import com.example.response.Transaction;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountEvent {

    private Integer accountId;
    private String status;
    private Transaction transaction;
}
