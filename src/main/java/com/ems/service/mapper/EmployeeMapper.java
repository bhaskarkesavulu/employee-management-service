package com.ems.service.mapper;

import com.ems.service.dto.EmployeeDto;
import com.ems.service.entity.Employees;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employees employees){
        return new EmployeeDto(
          employees.getId(),
                employees.getFirstName(),
                employees.getLastName(),
                employees.getEmail()
        );
    }

    public static Employees mapToEmployee(EmployeeDto employeeDto ){
        return new Employees(
          employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
