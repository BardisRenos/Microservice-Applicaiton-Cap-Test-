package com.example.service;

import com.example.dao.CustomerRepository;
import com.example.dto.CustomerDTO;
import com.example.entity.Customer;
import com.example.mapper.CustomerMapper;
import com.example.service.Interfaces.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * The Service layer of User
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    /**
     * This method returns all customers from the database
     * @return A list of CustomerDTO entities
     */
    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(CustomerMapper::toCustomerDTO).collect(Collectors.toList());
    }

    /**
     * This method returns a customer
     * @param id The given customer ID
     * @return A Customer entity
     */
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).get();
    }
}

