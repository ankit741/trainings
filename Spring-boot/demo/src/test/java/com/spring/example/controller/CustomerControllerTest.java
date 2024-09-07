package com.spring.example.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.autoconfig.example.model.Customer;
import com.autoconfig.example.service.CustomerService;
import com.spring.example.TestConfig;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CustomerController.class)
@ContextConfiguration(classes = {TestConfig.class})
class CustomerControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CustomerService customerService;

  @BeforeEach
  public void setUp() {
    // Initialize the EmployeeService or set up resources if needed
  }

  @AfterEach
  public void tearDown() {
    // Clean up resources or perform other cleanup tasks
  }
  @Test
  void shouldReturnAllCustomers() throws Exception {
    List<Customer> customers= Arrays.asList(new Customer("101","Ankit","29"),new Customer("102","Ajay","30"));
    given(customerService.getAllCustomers()).willReturn(customers);
    mockMvc.perform(get("/customers"))
        .andExpect(status().is2xxSuccessful());
  }

  @Test
  void shouldReturnAllCustomers2() throws Exception {
    List<Customer> customers= Arrays.asList(new Customer("101","Ankit","29"),new Customer("102","Ajay","30"));
    given(customerService.getAllCustomers()).willReturn(customers);
    ResultActions resultActions = mockMvc.perform(get("/customers"))
        .andExpect(status().is2xxSuccessful());
    assertThat(resultActions.andExpect(result -> System.out.println(result.getResponse())));

  }
}