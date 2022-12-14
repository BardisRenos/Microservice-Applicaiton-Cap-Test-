package com.example.service;

import com.example.dao.AccountRepository;
import com.example.dto.AccountDTO;
import com.example.dto.CustomerDTO;
import com.example.entity.Account;
import com.example.entity.Customer;
import com.example.mapper.AccountMapper;
import com.example.request.AccountRequest;
import com.example.response.Transaction;
import com.example.service.Interfaces.AccountServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The Service layer of Account
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountServiceInterface {

    private final AccountRepository accountRepository;

    private final CustomerServiceImpl customerService;

    /**
     * This method creates a new account (First checks if the customer exists)
     * @param createAccountRequest The given object that contains the Customer ID and the initial value
     * @return An AccountDTO class
     */
    @Override
    public AccountDTO createAccount(AccountRequest createAccountRequest) {

        Customer customer = customerService.getCustomerById(createAccountRequest.getCustomerID());

        Account account = new Account();
        account.setInitialCredit(createAccountRequest.getInitialCredit());
        account.setCustomer(customer);
        account.setDateCreation(LocalDateTime.now());

            if (createAccountRequest.getInitialCredit() > 0) {
                Transaction transaction = new Transaction();
                transaction.setAmount(account.getInitialCredit());
                transaction.setTime(LocalDateTime.now());

                account.getTransactions().add(transaction);

                return AccountMapper.toAccountTransactionDTO(accountRepository.save(account));
            }

        return AccountMapper.toAccountDTO(accountRepository.save(account));
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return null;
    }
}
