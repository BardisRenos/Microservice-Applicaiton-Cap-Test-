package com.example.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The TransactionDTO class
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class TransactionDTO implements Serializable {

    private Integer transactionID;
//    private Integer customerID;
    private Integer amount;
    private LocalDateTime time;
}
