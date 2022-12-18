package com.example.controller;

import com.example.dto.AccountDTO;
import com.example.request.AccountRequest;
import com.example.response.RestApiResponse;
import com.example.service.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/account/")
@RequiredArgsConstructor
public class AccountController {

    private final AccountServiceImpl accountService;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public RestApiResponse createCurrentAccount(@Valid @RequestBody AccountRequest accountRequest) {
        return accountService.createAccount(accountRequest);
    }

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDTO> getAllAccount() {
        return accountService.getAllAccount();
    }
}
