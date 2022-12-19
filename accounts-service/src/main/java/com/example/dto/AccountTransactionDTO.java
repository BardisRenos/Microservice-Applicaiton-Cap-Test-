package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * The AccountTransactionDTO class
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountTransactionDTO extends AccountDTO {

    private Integer transactionId;
    private Integer customerId;

    public AccountTransactionDTO(Integer accountID, Integer initialCredit, LocalDateTime dateCreation, Integer transactionId, Integer customerId) {
        super(accountID, initialCredit, dateCreation);
        this.transactionId = transactionId;
        this.customerId = customerId;
    }
}
