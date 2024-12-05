package com.vikram.hrmsloginportl.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;

@Entity
@Table(name = "salary")
@Data
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

      
   private Integer employeeId;

    @Column(nullable = false)
    private BigDecimal basicSalary;

    @Column(nullable = false)
    private BigDecimal daAllowance;

    @Column(nullable = false)
    private BigDecimal hraAllowance;

    @Column(nullable = false)
    private BigDecimal ltaAllowance;

    @Column(nullable = false)
    private BigDecimal medicalAllowance;

    @Column(nullable = false)
    private BigDecimal otherAllowances;

    @Column(nullable = false)
    private BigDecimal totalSalary;
}
