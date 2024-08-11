package com.autoconfig.example.config;

import com.autoconfig.example.service.CustomerService;
import com.autoconfig.example.service.CustomerServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class MyAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public CustomerService customerService() {
      return new CustomerServiceImpl();
    }
  }
