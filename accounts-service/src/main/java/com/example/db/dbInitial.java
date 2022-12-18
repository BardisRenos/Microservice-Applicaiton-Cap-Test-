package com.example.db;

import com.example.dao.AccountRepository;
import com.example.entity.Account;
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
    public CommandLineRunner initDB(AccountRepository accountRepository) {

        return args -> {

            List<Account> accounts = new ArrayList<>(Arrays.asList(
                    new Account(1, 10, LocalDateTime.now(), 1),
                    new Account(2, 20, LocalDateTime.now().plusDays(1), 2),
                    new Account(3, 30, LocalDateTime.now().plusDays(2), 3)));

            accountRepository.saveAll(accounts);

        };
    }
}
