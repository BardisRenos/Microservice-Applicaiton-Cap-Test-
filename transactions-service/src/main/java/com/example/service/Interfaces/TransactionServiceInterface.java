package com.example.service.Interfaces;

import com.example.dto.TransactionDTO;
import com.example.entity.Transaction;

import java.util.List;

public interface TransactionServiceInterface {

    List<TransactionDTO> getAllTransactions();

    Transaction addTransaction(Transaction transaction);
}
