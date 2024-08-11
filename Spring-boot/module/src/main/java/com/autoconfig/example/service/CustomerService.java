package com.autoconfig.example.service;

import com.autoconfig.example.model.Customer;
import java.util.List;

public interface CustomerService {

  Customer createCustomer(Customer customer);

  List<Customer> getAllCustomers();
}
