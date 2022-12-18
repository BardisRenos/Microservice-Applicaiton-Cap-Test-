package com.example.service.Interfaces;

import com.example.dto.AccountDTO;
import com.example.request.AccountRequest;
import com.example.response.RestApiResponse;

import java.util.List;

public interface AccountServiceInterface {

    RestApiResponse createAccount(AccountRequest accountRequest);

    List<AccountDTO> getAllAccount();
}
