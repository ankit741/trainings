package com.spring.example;


import com.autoconfig.example.service.CustomerService;
import com.autoconfig.example.service.CustomerServiceImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@TestConfiguration
@EnableAspectJAutoProxy
public class TestConfig {

  @Bean
  public CustomerService customerService() {
    return new CustomerServiceImpl();
  }

}
