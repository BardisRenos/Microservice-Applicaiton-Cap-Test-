package com.example.controller;

import com.example.dto.TransactionDTO;
import com.example.service.TransactionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/transaction/")
public class TransactionController {

    private final TransactionServiceImpl transactionService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDTO> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO getTransaction(@PathVariable("id") Integer id) {
        return transactionService.getTransaction(id);
    }
}
