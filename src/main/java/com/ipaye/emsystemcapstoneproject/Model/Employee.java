package com.ipaye.emsystemcapstoneproject.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="employees")
public class Employee {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Name is required")
    @Column(nullable=false)
    private String name;

    @Email(message="Email should be valid")
    @NotBlank(message="Email is required")
    @Column(nullable=false, unique=true)
    private String email;

    @NotBlank(message="Department is required")
    @Column(nullable=false)
    private String department;

    @NotNull(message="Role Id is required")
    @Column(name="Role_id", nullable=false)
    private Long roleId;

    @NotNull(message="Salary is required")
    @Min(value=0, message="Salary must be a positive number")
    @Column(nullable=false)
    private Double salary;


    public Employee(Long id, String name, String email, String department, Long roleId, Double salary) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.department=department;
        this.roleId=roleId;
        this.salary=salary;
    }

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department=department;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId=roleId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary=salary;
    }
}
