package com.example.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private Integer transactionID;
    private Integer amount;
    private LocalDateTime time;
}
