package com.ems.service.controller;

import com.ems.service.dto.EmployeeDto;
import com.ems.service.entity.Employees;
import com.ems.service.service.impl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeServiceImpl employeeService;

    @PostMapping(value = "/save")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){


    EmployeeDto employeeDto1 = employeeService.createEmployee(employeeDto);
    return new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){

        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<EmployeeDto>> list(){

        List<EmployeeDto> employeeDtos = employeeService.list();

       return ResponseEntity.ok(employeeDtos);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employeeDto){


        EmployeeDto employeeDto1 = employeeService.updateEmployee(employeeId, employeeDto);
        return ResponseEntity.ok(employeeDto1);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id")Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Deleted Successfully with ID is.");
    }

}
