package com.example.response;

import com.example.entity.Account;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RestApiResponse {

    private List<Transaction> transactions;
    private Account account;
}
