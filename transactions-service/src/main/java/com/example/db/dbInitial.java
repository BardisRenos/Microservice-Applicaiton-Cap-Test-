package com.example.db;

import com.example.dao.TransactionRepository;
import com.example.entity.Transaction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class dbInitial {

    @Bean
    public CommandLineRunner initDB(TransactionRepository transactionRepository) {

        return args -> {

            List<Transaction> transactions = new ArrayList<>(Arrays.asList(
                    new Transaction(1, 10, LocalDateTime.now()),
                    new Transaction(2, 20,  LocalDateTime.now().plusDays(1)),
                    new Transaction(3, 30, LocalDateTime.now().plusDays(2))));

            transactionRepository.saveAll(transactions);

        };
    }
}
