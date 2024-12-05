package com.vikram.hrmsloginportl.controller;

import com.vikram.hrmsloginportl.Entity.Salary;
import com.vikram.hrmsloginportl.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @PostMapping("/add")
    public String addSalary(@RequestBody Salary salary) {
        salaryService.addSalary(salary);
        return "Salary added successfully!";
    }

    @PostMapping("/bulk-add")
    public String addBulkSalaries(@RequestBody List<Salary> salaries) {
        salaryService.addBulkSalaries(salaries);
        return "Bulk salary information added successfully!";
    }


    @GetMapping("/total-amount")
    public BigDecimal getTotalAmountPaid() {
        return salaryService.getTotalAmountPaid();
    }
}

