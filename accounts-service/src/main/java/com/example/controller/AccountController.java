package com.example.controller;

import com.example.dto.AccountDTO;
import com.example.dto.CustomerDTO;
import com.example.request.AccountRequest;
import com.example.service.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
@RequiredArgsConstructor
public class AccountController {

    private final AccountServiceImpl accountService;


    @PostMapping("account")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDTO createCurrentAccount(@Valid @RequestBody AccountRequest accountRequest) {
        return accountService.createAccount(accountRequest);
    }

    @GetMapping("customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> getAllCustomers() {
        return accountService.getAllCustomers();
    }
}
