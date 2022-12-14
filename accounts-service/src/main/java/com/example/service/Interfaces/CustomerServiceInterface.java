package com.example.service.Interfaces;

import com.example.dto.CustomerDTO;
import com.example.dto.CustomerTransactionDTO;
import java.util.List;

/**
 * The User Service Interface. All methods that User Service has.
 */
public interface CustomerServiceInterface {

    CustomerTransactionDTO getCustomerWithTransactions(String surname);

    List<CustomerDTO> getAllCustomers();
}
