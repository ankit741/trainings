package com.spring.example.config;

import com.autoconfig.example.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "customer.disabled", havingValue = "false")
public class ServiceConfig extends MyAutoConfiguration {

}
