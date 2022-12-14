package com.example.service.Interfaces;

import com.example.dto.AccountDTO;
import com.example.dto.CustomerDTO;
import com.example.request.AccountRequest;

import java.util.List;

public interface AccountServiceInterface {

    AccountDTO createAccount(AccountRequest accountRequest);
    List<CustomerDTO> getAllCustomers();

}
