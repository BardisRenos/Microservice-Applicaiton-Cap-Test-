package com.example.dto;

import com.example.response.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The AccountTransactionDTO class
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountTransactionDTO extends AccountDTO {

    private List<Transaction> transactions;

    public AccountTransactionDTO(Integer accountID, Integer initialCredit, LocalDateTime dateCreation, List<Transaction> transactions) {
        super(accountID, initialCredit, dateCreation);
        this.transactions = transactions;
    }
}
