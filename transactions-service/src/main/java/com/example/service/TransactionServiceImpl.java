package com.example.service;

import com.example.dao.TransactionRepository;
import com.example.dto.TransactionDTO;
import com.example.mapper.TransactionMapper;
import com.example.service.Interfaces.TransactionServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionServiceInterface {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream().map(TransactionMapper::toTransactionDTO).collect(Collectors.toList());
    }

    public TransactionDTO getTransaction(Integer id) {
        return transactionRepository.findById(id).map(TransactionMapper::toTransactionDTO).get();
    }
}
