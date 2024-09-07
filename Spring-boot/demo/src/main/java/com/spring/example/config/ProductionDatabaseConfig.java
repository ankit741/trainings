package com.spring.example.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class ProductionDatabaseConfig {

  @Bean
  public DataSource dataSource() {
    return null;
  }
}