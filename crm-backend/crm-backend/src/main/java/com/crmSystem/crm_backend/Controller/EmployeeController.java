package com.crmSystem.crm_backend.Controller;


import com.crmSystem.crm_backend.DTO.EmployeeDto;
import com.crmSystem.crm_backend.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //get all employee
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return new ResponseEntity<List<EmployeeDto>>(employeeService.findAllEmployees(), HttpStatus.OK);
    }
    //add employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> addNewEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<EmployeeDto>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    //get employee by id REST API
    @GetMapping("/employee/id/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        return new ResponseEntity<EmployeeDto>(employeeService.findEmployeeDtoById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable("id") Long id, @RequestBody EmployeeDto newemployeeDto) {
        return new ResponseEntity<EmployeeDto>(employeeService.updateEmployee(id, newemployeeDto), HttpStatus.OK);
    }

    //delete employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
    }
}
