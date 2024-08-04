package com.crmSystem.crm_backend.Mapper;

import com.crmSystem.crm_backend.Collections.Employee;
import com.crmSystem.crm_backend.DTO.EmployeeDto;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPhoneNumber(),
                employee.getSin(),
                employee.getPayRate()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getPhoneNumber(),
                employeeDto.getSin(),
                employeeDto.getPayRate()
        );
    }

    public static List<EmployeeDto> mapToEmployeeDtoList(List<Employee> employees) {
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }
}
