package com.example.service;

import com.example.dao.TransactionRepository;
import com.example.dto.TransactionDTO;
import com.example.entity.Transaction;
import com.example.mapper.TransactionMapper;
import com.example.service.Interfaces.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream().map(TransactionMapper::toTransactionDTO).collect(Collectors.toList());
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public TransactionDTO getTransaction(Integer id) {
        return transactionRepository.findById(id).map(TransactionMapper::toTransactionDTO).get();
    }
}
