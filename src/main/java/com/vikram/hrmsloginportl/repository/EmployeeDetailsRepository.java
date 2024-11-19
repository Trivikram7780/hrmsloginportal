package com.vikram.hrmsloginportl.repository;

import com.vikram.hrmsloginportl.Entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {
    EmployeeDetails findByName(String name);
}