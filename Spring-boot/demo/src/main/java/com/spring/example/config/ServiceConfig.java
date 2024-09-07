package com.spring.example.config;

import com.autoconfig.example.service.CustomerService;
import com.spring.example.service.NewCustomerServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnProperty(value = "customer.disabled", havingValue = "false")
public class ServiceConfig {

  @Bean(name = "newCustomerService")
  public CustomerService customerService() {
    return new NewCustomerServiceImpl();
  }

}
