package com.example.service;

import com.example.dao.TransactionRepository;
import com.example.dto.TransactionDTO;
import com.example.mapper.TransactionMapper;
import com.example.service.Interfaces.TransactionServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ResponseStatus
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionServiceInterface {

    private final TransactionRepository transactionRepository;

    @Override
    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream().map(TransactionMapper::toTransactionDTO).collect(Collectors.toList());
    }
}
