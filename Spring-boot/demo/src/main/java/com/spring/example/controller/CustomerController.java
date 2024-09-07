package com.spring.example.controller;

import com.autoconfig.example.model.Customer;
import com.autoconfig.example.service.CustomerService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {


  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService=customerService;
  }

  @GetMapping
  public List<Customer> getAllCustomers(){
    return customerService.getAllCustomers();
  }

}
