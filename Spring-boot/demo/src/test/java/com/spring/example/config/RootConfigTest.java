package com.spring.example.config;

import static org.junit.jupiter.api.Assertions.*;

import com.autoconfig.example.config.MyAutoConfiguration;
import com.autoconfig.example.service.CustomerService;
import com.spring.example.service.ShapeService;
import com.spring.example.service.Square;
import java.util.Arrays;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, MyAutoConfiguration.class, ServiceConfig.class})
public class RootConfigTest {

  @Autowired
  private ApplicationContext applicationContext;
  @Autowired
  private ShapeService shapeService;
  @Autowired
  private CustomerService customerService;
  @Autowired
  private CustomerService newCustomerService;

  @BeforeAll
  public static void init() throws Exception {
    System.out.println("init method");
  }
  @Test
  void testApplicationContext(){
    assertNotNull(applicationContext);
  }

  @Test
  public void testSquare() throws Exception {
    // printSpringBeans();
    System.out.println(customerService.getAllCustomers());
    System.out.println(newCustomerService.getAllCustomers());
    Square square1 = new Square();
    assertEquals("Drawing the Square", shapeService.getShape());
  }

  private void printSpringBeans() {
    System.out.println("Let's inspect the beans provided by Spring Boot:");
    String[] beanNames = applicationContext.getBeanDefinitionNames();
    Arrays.sort(beanNames);
    for (String beanName : beanNames) {
      System.out.println(beanName);
    }
  }

  @AfterAll
  public static void destroy() throws Exception {
    System.out.println("after all method");
  }
}