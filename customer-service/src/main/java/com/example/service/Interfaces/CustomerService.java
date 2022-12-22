package com.example.service.Interfaces;

import com.example.dto.CustomerDTO;

import java.util.List;

/**
 * The User Service Interface. All methods that User Service has.
 */
public interface CustomerService {

    List<CustomerDTO> getAllCustomers();
}
