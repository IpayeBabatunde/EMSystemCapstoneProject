package com.ipaye.emsystemcapstoneproject.Repository;


import com.ipaye.emsystemcapstoneproject.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Employee b WHERE b.id > 0")
    boolean createAndSave();

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Employee b WHERE b.id > 0")
    Boolean deleteEmployee();

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Employee b WHERE b.id > 0")
    Boolean updateEmployee();

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Employee b WHERE b.id > 0")
    Boolean AddANewEmployee();
}
