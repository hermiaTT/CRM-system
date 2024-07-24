package com.crmSystem.crm_backend.Service;

import com.crmSystem.crm_backend.Collections.Employee;
import com.crmSystem.crm_backend.DTO.EmployeeDto;
import com.crmSystem.crm_backend.Mapper.EmployeeMapper;
import com.crmSystem.crm_backend.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        //comvert dto to actual  employee
        Employee employee =employeeRepository.insert(EmployeeMapper.mapToEmployee(employeeDto)) ;
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
