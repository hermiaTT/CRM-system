package com.crmSystem.crm_backend.Service;

import com.crmSystem.crm_backend.Collections.Employee;
import com.crmSystem.crm_backend.DTO.EmployeeDto;
import com.crmSystem.crm_backend.Exception.ResourcerNotFoundException;
import com.crmSystem.crm_backend.Mapper.EmployeeMapper;
import com.crmSystem.crm_backend.Repository.EmployeeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //get all employee
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return EmployeeMapper.mapToEmployeeDtoList(employees);
    }

    //create new employee
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        //comvert dto to actual  employee
        Employee employee =employeeRepository.insert(EmployeeMapper.mapToEmployee(employeeDto)) ;
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    //get employee by id
    public EmployeeDto getEmployeeDtoById(ObjectId id) {
        Employee employee= employeeRepository.findById(id)
                .orElseThrow(() -> new ResourcerNotFoundException("Employee not found"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
