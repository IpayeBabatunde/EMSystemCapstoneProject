package com.ipaye.emsystemcapstoneproject;

import com.ipaye.emsystemcapstoneproject.Model.Employee;
import com.ipaye.emsystemcapstoneproject.Repository.EmployeeRepository;
import com.ipaye.emsystemcapstoneproject.Service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;


@SpringBootTest
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void ShouldCreateAndSaveEmployee(){
        // instructions
        when(employeeRepository.createAndSave()).thenReturn(true);

        // call the method
        String results = employeeService.createEmployee();

        // check results
        assertEquals("Created Successfully" , results);

    }

    @Test
    void ShouldDeleteEmployee(){

        // instructions
        when(employeeRepository.deleteEmployee()).thenReturn(true);

        // call the method
        String results = employeeService.deleteEmployee();

        //check results
        assertEquals("Deleted Successfully", results);
    }

    @Test
    void ShouldUpdateEmployee(){

        // instructions
        when(employeeRepository.updateEmployee()).thenReturn(true);

        // call the method
        String results = employeeService.updateEmployee();

        // check results
        assertEquals("Updated Successfully", results);
    }

    @Test
    void ShouldAddANewEmployee(){
        //instructions
        when(employeeRepository.AddANewEmployee()).thenReturn(true);

        // call the method
        String results = employeeService.AddANewEmployee();

        // check results
        assertEquals("Added Successfully", results);

    }

    @Test
    void WhenEmployeeDataNotEnteredCorrectly(){
        // instruction
        when(employeeRepository.createAndSave()).thenReturn(false);

        // call method
        String results = employeeService.createEmployee();

        // results
        assertEquals("Error in Creating Employee, try again", results);
    }

    @Test
    void DeleteANonExistingEmployee(){

        // instructions
        when(employeeRepository.deleteEmployee()).thenReturn(false);

        // call the method
        String results = employeeService.deleteEmployee();

        // results
        assertEquals("Null Employee cannot be deleted, delete failed", results);
    }

    @Test
    void EmployeeNotUpdatedCorrectly(){

        // instructions
        when(employeeRepository.updateEmployee()).thenReturn(false);

        // call method
        String results = employeeService.updateEmployee();

        // results
        assertEquals("Error in updating, try entering a correct information", results);
    }

    @Test
    void AddingEmployeeWithIncorrectInformation(){

        // instruction
        when(employeeRepository.AddANewEmployee()).thenReturn(false);

        // call the method
        String results = employeeService.AddANewEmployee();

        // results
        assertEquals("oops, Add with correct information, try again", results);
    }


}
