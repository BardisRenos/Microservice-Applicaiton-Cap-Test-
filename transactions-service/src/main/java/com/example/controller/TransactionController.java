package com.example.controller;

import com.example.dto.TransactionDTO;
import com.example.service.TransactionServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/vi/transaction")
public class TransactionController {

    private final TransactionServiceImpl transactionService;


    @PostMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDTO> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}
