package com.vikram.hrmsloginportl.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String employeeType;
    private String firstname;
    private String middlename;
    private String lastname;
    private LocalDate dob;
    private String gender;
    private String company;
    private String role;
    private LocalDate dateOfJoin;
    private String username;


}