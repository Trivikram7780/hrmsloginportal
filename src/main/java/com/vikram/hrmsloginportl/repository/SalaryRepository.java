package com.vikram.hrmsloginportl.repository;

import com.vikram.hrmsloginportl.Entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

    @Query("SELECT SUM(s.totalSalary) FROM Salary s")
    BigDecimal calculateTotalAmountPaid();

    Salary findByEmployeeId(Long employeeId);

}

