package com.spring.example.config;


import com.spring.example.service.Circle;
import com.spring.example.service.ShapeService;
import com.spring.example.service.Square;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

/*
since I have added auto config class in META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
spring will automatically import the auto config and registered the bean classes.

if you want to import the config class manually it can be done as mentioned below-

@Import(MyAutoConfiguration.class)

 */

@Configuration
public class RootConfig {

  @Bean
  @Primary
  Square square() {
    return new Square();
  }

  @Bean
  Circle circle() {
    return new Circle();
  }

  @Bean
  ShapeService shapeService() {
    return new ShapeService();
  }


}
