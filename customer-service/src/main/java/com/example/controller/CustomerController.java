package com.example.controller;


import com.example.dto.CustomerDTO;
import com.example.entity.Customer;
import com.example.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/customer/")
public class CustomerController {

    private final CustomerServiceImpl userService;

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> getAllCustomers() {
        return userService.getAllCustomers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable("id") Integer id) {
        return userService.getCustomerById(id);
    }

}
