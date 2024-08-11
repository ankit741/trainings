package com.autoconfig.example.service;

import com.autoconfig.example.model.Customer;
import java.util.Arrays;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

  @Override
  public Customer createCustomer(Customer customer) {
    return new Customer("101","Ankit","29");
  }

  @Override
  public List<Customer> getAllCustomers() {
    List<Customer> customers= Arrays.asList(new Customer("101","Ankit","29"),new Customer("102","Ajay","30"));
    return customers;
  }
}
