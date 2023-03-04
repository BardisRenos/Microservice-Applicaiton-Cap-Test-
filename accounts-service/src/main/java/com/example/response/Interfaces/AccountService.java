package com.example.response.Interfaces;

import com.example.dto.AccountDTO;
import com.example.request.AccountRequest;
import com.example.response.RestApiResponse;

import java.util.List;

public interface AccountService {

    RestApiResponse createAccount(AccountRequest accountRequest);

    List<AccountDTO> getAllAccount();
}
