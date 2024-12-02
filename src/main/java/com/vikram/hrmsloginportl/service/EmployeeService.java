package com.vikram.hrmsloginportl.service;

import com.vikram.hrmsloginportl.Entity.Employee;
import com.vikram.hrmsloginportl.dto.EmployeeDTO;
import com.vikram.hrmsloginportl.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepository.findByUsername(employeeDTO.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists.");
        }
        Employee employee = mapDtoToEntity(employeeDTO);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            if (!employee.getUsername().equals(employeeDTO.getUsername()) && employeeRepository.findByUsername(employeeDTO.getUsername()).isPresent()) {
                throw new IllegalArgumentException("Username already exists.");
            }
            mapDtoToEntity(employeeDTO, employee);
            return employeeRepository.save(employee);
        } else {
            throw new NoSuchElementException("Employee not found");
        }
    }
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    private Employee mapDtoToEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        mapDtoToEntity(dto, employee);
        return employee;
    }

    private void mapDtoToEntity(EmployeeDTO dto, Employee employee) {
        employee.setEmployeeType(dto.getEmployeeType());
        employee.setFirstname(dto.getFirstname());
        employee.setMiddlename(dto.getMiddlename());
        employee.setLastname(dto.getLastname());
        employee.setDob(dto.getDob());
        employee.setGender(dto.getGender());
        employee.setCompany(dto.getCompany());
        employee.setRole(dto.getRole());
        employee.setDateOfJoin(dto.getDateOfJoin());
        employee.setAge(dto.getDob() != null ? Period.between(dto.getDob(), LocalDate.now()).getYears() : null);
        employee.setUsername(dto.getUsername());
    }
}

