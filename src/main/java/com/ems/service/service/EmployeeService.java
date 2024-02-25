package com.ems.service.service;

import com.ems.service.dto.EmployeeDto;
import com.ems.service.entity.Employees;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> list();

    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

    public void deleteEmployee(Long id);
}
