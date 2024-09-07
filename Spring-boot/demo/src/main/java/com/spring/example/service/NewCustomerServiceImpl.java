package com.spring.example.service;

import com.autoconfig.example.model.Customer;
import com.autoconfig.example.service.CustomerService;
import java.util.Collections;
import java.util.List;

public class NewCustomerServiceImpl implements CustomerService {

  @Override
  public Customer createCustomer(Customer customer) {
    return new Customer("","","");
  }

  @Override
  public List<Customer> getAllCustomers() {
    return Collections.EMPTY_LIST;
  }
}
