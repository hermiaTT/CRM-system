package com.crmSystem.crm_backend.Service;

import com.crmSystem.crm_backend.Collections.Employee;
import com.crmSystem.crm_backend.DTO.EmployeeDto;
import com.crmSystem.crm_backend.Exception.CustomServiceException;
import com.crmSystem.crm_backend.Exception.DuplicatedDataException;
import com.crmSystem.crm_backend.Exception.ResourcerNotFoundException;
import com.crmSystem.crm_backend.Mapper.EmployeeMapper;
import com.crmSystem.crm_backend.Repository.EmployeeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //create new employee
    @Transactional
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        try{
            Employee savedEmployee = employeeRepository.save(employee);
            return EmployeeMapper.mapToEmployeeDto(savedEmployee);
        } catch (DataIntegrityViolationException e){
            throw new DuplicatedDataException("Employee already exists");
        } catch (Exception e){
            throw new CustomServiceException("An unexpected error occurred",e);
        }
    }

    //get all employee
    public List<EmployeeDto> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return EmployeeMapper.mapToEmployeeDtoList(employees);
    }

    //get employee by id
    public EmployeeDto findEmployeeDtoById(Long id) {
        Employee employee= employeeRepository.findById(id)
                .orElseThrow(() -> new ResourcerNotFoundException("Employee not found"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    //update employee
    public EmployeeDto updateEmployee(Long id, EmployeeDto newEmployeeDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourcerNotFoundException("Employee not found with the given id"));
        employee.setFirstName(newEmployeeDto.getFirstName());
        employee.setLastName(newEmployeeDto.getLastName());
        employee.setPhoneNumber(newEmployeeDto.getPhoneNumber());
        employee.setSin(newEmployeeDto.getSin());
        employee.setPayRate(newEmployeeDto.getPayRate());
        //update method

        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    //delete employee
    public void deleteEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourcerNotFoundException("Employee not found with the given id"));
        employeeRepository.deleteById(id);
    }
}
