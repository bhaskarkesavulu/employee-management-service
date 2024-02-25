package com.ems.service.service.impl;

import com.ems.service.dto.EmployeeDto;
import com.ems.service.entity.Employees;
import com.ems.service.exception.ResourceNotFoundException;
import com.ems.service.mapper.EmployeeMapper;
import com.ems.service.repository.EmployeeRepository;
import com.ems.service.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employees employees = EmployeeMapper.mapToEmployee(employeeDto);
        Employees savedEmployee =  employeeRepository.save(employees);
        log.info("Saved Employees is : {}",savedEmployee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {

        Employees employees = employeeRepository.findById(id)
                .orElseThrow( ()->
                        new ResourceNotFoundException("Employee Not Found with given ID : "+id));
        log.info("Employee By ID Is : {}",employees);
        return EmployeeMapper.mapToEmployeeDto(employees);
    }

    @GetMapping(value = "/list")
    @Override
    public List<EmployeeDto> list() {
        List<Employees> employees = employeeRepository.findAll();
        log.info("List of Employee is : {}",employees);
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {

        Employees employees = employeeRepository.findById(id)
                .orElseThrow( ()->
                        new ResourceNotFoundException("Employee Not Found with given ID : "+id));
        employees.setFirstName(employeeDto.getFirstName());
        employees.setLastName(employeeDto.getLastName());
        employees.setEmail(employeeDto.getEmail());
        Employees updatedEmployees = employeeRepository.save(employees);
        log.info("Updated Employee is : {}",updatedEmployees);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployees);
    }

    @Override
    public void deleteEmployee(Long id) {

        Employees employees = employeeRepository.findById(id)
                .orElseThrow( ()->
                        new ResourceNotFoundException("Employee Not Found with given ID : "+id));
        log.info("Deleted Object is : {}",employees);
        log.info("https://www.youtube.com/watch?v=SauEhnjTqV4&list=PLGRDMO4rOGcNLnW1L2vgsExTBg-VPoZHr&index=12");
        employeeRepository.deleteById(id);

    }
}
