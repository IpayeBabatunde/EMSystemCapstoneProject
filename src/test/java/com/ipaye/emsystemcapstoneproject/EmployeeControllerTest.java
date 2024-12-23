package com.ipaye.emsystemcapstoneproject;

import com.ipaye.emsystemcapstoneproject.Controller.EmployeeController;
import com.ipaye.emsystemcapstoneproject.Model.Employee;
import com.ipaye.emsystemcapstoneproject.Service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

   @Mock
   private EmployeeController employeeController;
    @Autowired
    private RestTemplateBuilder restTemplate;


    @Test
    void shouldAddNewEmployee() throws Exception {
        mockMvc.perform(post("/employees")
                .content("{\"name\":\"John Doe\"}")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void listAllEmployees() throws Exception {
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }


    @Test
    void shouldUpdateEmployeeSuccessfully() throws Exception {
        // Arrange : Prepare input data
        String employeeId = "1";
        String updatedEmployeeJson = "{\"name\": \"Jenifa Aloze\", \"email\":\"J.Aloze@gmail.com\", \"department\": \"HR\" }";

        // Act: Perform the put request to update employee
        mockMvc.perform(put("/employees/{id}", employeeId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedEmployeeJson))
                .andExpect(status().isOk())
                .andExpect(content().json(updatedEmployeeJson));
    }


    @Test
    void shouldDeleteEmployeeSuccessfully() throws Exception{

        // Arrange: set up the ID of the employee to delete
        String employeeId = "1";

        // Act: perform the Delete request to delete the employee
        mockMvc.perform(delete("/employees/{id}", employeeId))
                .andExpect(status().isNoContent());
    }



}
