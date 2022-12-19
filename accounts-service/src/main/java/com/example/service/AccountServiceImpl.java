package com.example.service;

import com.example.RabbitExchangeConfig.MessageConfig;
import com.example.dao.AccountRepository;
import com.example.dto.AccountDTO;
import com.example.dto.AccountTransactionDTO;
import com.example.entity.Account;
import com.example.event.AccountEvent;
import com.example.mapper.AccountMapper;
import com.example.request.AccountRequest;
import com.example.response.Customer;
import com.example.response.RestApiResponse;
import com.example.response.Transaction;
import com.example.service.Interfaces.AccountServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


/**
 * The Service layer of Account
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountServiceInterface {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private WebClient.Builder webClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * This method creates a new account (First checks if the customer exists)
     * @param accountRequest The given object that contains the Customer ID and the initial value
     * @return An AccountDTO class
     */
    @Override
    public RestApiResponse createAccount(AccountRequest accountRequest) {

        final String CUSTOMER_BASE_URL = "http://CUSTOMER-SERVICE/api/v1";

        RestApiResponse response = new RestApiResponse();

        Customer customer = webClient.baseUrl(CUSTOMER_BASE_URL).build().get().uri("/customer/" + accountRequest.getCustomerID())
                .retrieve().toEntity(Customer.class).block().getBody();

        customer.setCustomerID(accountRequest.getCustomerID());

        Account account = new Account();
        account.setAccountID(4);
        account.setInitialCredit(accountRequest.getInitialCredit());
        account.setCustomerID(customer.getCustomerID());
        account.setDateCreation(LocalDateTime.now());

        response.setAccount(account);

        if (accountRequest.getInitialCredit() > 0) {
            Transaction transaction = new Transaction();
            transaction.setTransactionID(4);
            transaction.setAmount(account.getInitialCredit());
            transaction.setTime(LocalDateTime.now());

            account.setTransactionID(transaction.getTransactionID());
            AccountEvent accountEvent = AccountEvent.builder().accountId(account.getAccountID()).status("CREATED").transaction(transaction).build();

            rabbitTemplate.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, accountEvent);
            response.getTransactions().add(transaction);

            accountRepository.save(account);
            return response;
        }

        accountRepository.save(account);
        return response;
    }

    @Override
    public List<AccountDTO> getAllAccount() {
        return accountRepository.findAll().stream().map(AccountMapper::toAccountDTO).collect(Collectors.toList());
    }

    public RestApiResponse getAccountWithTransaction(Integer id) {
        RestApiResponse restApiResp = new RestApiResponse();

        List<AccountTransactionDTO> res = accountRepository.findByCustomerID(id).stream().map(AccountMapper::toAccountTransactionDTO).collect(Collectors.toList());

        final String CUSTOMER_BASE_URL = "http://CUSTOMER-SERVICE/api/v1";
        Customer customer = webClient.baseUrl(CUSTOMER_BASE_URL).build().get().uri("/customer/"+res.get(0).getCustomerId()).retrieve().toEntity(Customer.class).block().getBody();
        customer.setCustomerID(res.get(0).getCustomerId());

        final String TRANSACTION_BASE_URL = "http://TRANSACTION-SERVICE/api/v1";

        Transaction transaction = webClient.baseUrl(TRANSACTION_BASE_URL).build().get().uri("/transaction/" + res.get(0).getTransactionId())
                .retrieve().toEntity(Transaction.class).block().getBody();

        restApiResp.setAccount(customer);
        restApiResp.getTransactions().add(transaction);

        return restApiResp;
    }
}
