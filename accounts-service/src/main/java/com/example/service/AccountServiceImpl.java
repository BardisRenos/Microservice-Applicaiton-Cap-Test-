package com.example.service;

import com.example.dao.AccountRepository;
import com.example.dto.AccountDTO;
import com.example.entity.Account;
import com.example.mapper.AccountMapper;
import com.example.request.AccountRequest;
import com.example.response.Customer;
import com.example.response.RestApiResponse;
import com.example.response.Transaction;
import com.example.service.Interfaces.AccountServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


/**
 * The Service layer of Account
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountServiceInterface {

    private final AccountRepository accountRepository;

    private final WebClient.Builder webClient;
    /**
     * This method creates a new account (First checks if the customer exists)
     * @param accountRequest The given object that contains the Customer ID and the initial value
     * @return An AccountDTO class
     */
    @Override
    public RestApiResponse createAccount(AccountRequest accountRequest) {

        final String CUSTOMER_BASE_URL = "http://CUSTOMER-SERVICE/api/v1";
        final String TRANSACTION_BASE_URL = "http://TRANSACTION-SERVICE/api/v1";

        RestApiResponse response = new RestApiResponse();

        Customer customer = webClient.baseUrl(CUSTOMER_BASE_URL).build().get().uri("/customer/"+accountRequest.getCustomerID())
                .retrieve().toEntity(Customer.class).block().getBody();
        customer.setCustomerID(accountRequest.getCustomerID());


        Account account = new Account();
        account.setInitialCredit(accountRequest.getInitialCredit());
        account.setCustomerID(customer.getCustomerID());
        account.setDateCreation(LocalDateTime.now());
        response.setAccount(account);

            if (accountRequest.getInitialCredit() > 0) {
                Transaction transaction = new Transaction();
                transaction.setAmount(account.getInitialCredit());
                transaction.setTime(LocalDateTime.now());

//                account.getTransactions().add(transaction);

                Transaction trans = webClient.baseUrl(TRANSACTION_BASE_URL).build().post().uri("/transaction")
                        .body(Mono.just(transaction), Transaction.class)
                        .retrieve()
                        .bodyToMono(Transaction.class).block();

                response.getTransactions().add(trans);

                return response;
//                return AccountMapper.toAccountTransactionDTO(accountRepository.save(account));
            }

            Account account1 = accountRepository.save(account);
        return response;
//        return AccountMapper.toAccountDTO(accountRepository.save(account));
    }

    @Override
    public List<AccountDTO> getAllAccount() {
        return accountRepository.findAll().stream().map(AccountMapper::toAccountDTO).collect(Collectors.toList());
    }

}
