package com.example.service;

import com.example.dto.CustomerDTO;

import java.util.List;

/**
 * The User Service Interface. All methods that User Service has.
 */
public interface CustomerService {

//    CustomerTransactionDTO getCustomerWithTransactions(String surname) throws CustomerNotFoundException;

    List<CustomerDTO> getAllCustomers();
}
