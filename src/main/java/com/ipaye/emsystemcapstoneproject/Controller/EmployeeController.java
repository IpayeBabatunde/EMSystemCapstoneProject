package com.ipaye.emsystemcapstoneproject.Controller;


import com.ipaye.emsystemcapstoneproject.Model.Employee;
import com.ipaye.emsystemcapstoneproject.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
public class EmployeeController {


    static Employee employee = new Employee(1L, "John Doe", "JohnD@gmail.com","FINANCE", 2L, 70000.00);


    @GetMapping("/employees")
    public Employee getEmployees(){
        return employee;
    }


    @GetMapping()

    @PostMapping("/employees/name")
    public Employee editEmployeeName(){
        employee.setName("wale johnson");
        return employee;
    }

//   private List<Employee> employeeList = new ArrayList<>();
//
//    @PostMapping
//    public void addEmployee(@RequestBody Employee employee){
//            employeeList.add(employee);
//    }
//
////    @GetMapping
////    public List<Employee> listAllEmployees(){
////        return employeeList;
////    }
//
//
//    @PutMapping("{id}")
//    public ResponseEntity<Employee> updateEmployee(
//            @PathVariable String id,
//            @RequestBody Employee updatedEmployee
//    ) {
//        return ResponseEntity.ok(updatedEmployee);
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable String id){
//        return ResponseEntity.noContent().build();
//    }
//
//
//    @GetMapping("/employees/id")
//    public int getEmployeeDetails(@PathVariable int id){
//        return id;
//
//    }


}
