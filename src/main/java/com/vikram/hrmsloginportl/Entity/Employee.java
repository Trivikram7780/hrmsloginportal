package com.vikram.hrmsloginportl.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employees", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employeeType; // Admin/User
    private String firstname;
    private String middlename;
    private String lastname;
    private LocalDate dob;
    private String gender;
    private Integer age;
    private String company;
    private String role;
    private LocalDate dateOfJoin;
    @Column(nullable = false, unique = true)
    private String username;
}
