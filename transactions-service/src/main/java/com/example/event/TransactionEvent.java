package com.example.event;

import com.example.entity.Transaction;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionEvent {

    private Integer accountId;
    private String status;
    private Transaction transaction;
}
