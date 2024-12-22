package com.ipaye.emsystemcapstoneproject.Service;
import com.ipaye.emsystemcapstoneproject.Model.Employee;

import com.ipaye.emsystemcapstoneproject.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository=employeeRepository;
    }

    public String createEmployee(){
        if(employeeRepository.createAndSave()){
            return "Created Successfully";
        }
        else
            return "Error in Creating Employee, try again";
    }

    public String deleteEmployee() {
        if(employeeRepository.deleteEmployee()){
            return "Deleted Successfully";
        }
        else
            return "Null Employee cannot be deleted, delete failed";
    }

    public String updateEmployee() {
        if(employeeRepository.updateEmployee()) {
            return "Updated Successfully";

        }
        else
            return "Error in updating, try entering a correct information";
    }

    public String AddANewEmployee() {
        if(employeeRepository.AddANewEmployee()){
            return "Added Successfully";
        }
        return
                "oops, Add with correct information, try again";
    }
}
