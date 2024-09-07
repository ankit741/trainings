package com.spring.example.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class EmbeddedDatabaseConfig {

  @Bean
  public DataSource dataSource() {
    return null;
  }
}
 