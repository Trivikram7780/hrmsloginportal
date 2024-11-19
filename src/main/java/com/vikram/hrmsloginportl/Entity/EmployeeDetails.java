package com.vikram.hrmsloginportl.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employeedetails")
public class EmployeeDetails {
    @Id
    private Long id;
    private String name;
    private String gender;
    private Integer age;
    private String dob;
    private String role;
}
