package com.spring.example.config;


import org.springframework.context.annotation.Configuration;

/*
since I have added auto config class in META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
spring will automatically import the auto config and registered the bean classes.

if you want to import the config class manually it can be done as mentioned below-

@Import(MyAutoConfiguration.class)

 */

@Configuration
public class RootConfig {


}
