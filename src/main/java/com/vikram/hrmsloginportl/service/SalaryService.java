package com.vikram.hrmsloginportl.service;

import com.vikram.hrmsloginportl.Entity.Salary;
import com.vikram.hrmsloginportl.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    public void addSalary(Salary salary) {
        // Calculate total salary if not already set
        if (salary.getTotalSalary() == null) {
            salary.setTotalSalary(salary.getBasicSalary()
                    .add(salary.getDaAllowance())
                    .add(salary.getHraAllowance())
                    .add(salary.getLtaAllowance())
                    .add(salary.getMedicalAllowance())
                    .add(salary.getOtherAllowances()));
        }
        salaryRepository.save(salary);
    }

    public void addBulkSalaries(List<Salary> salaries) {
        for (Salary salary : salaries) {
            addSalary(salary);
        }
    }



    public BigDecimal getTotalAmountPaid() {
        return salaryRepository.calculateTotalAmountPaid();
    }


}
