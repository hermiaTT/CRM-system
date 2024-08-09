package com.crmSystem.crm_backend.Service;

import com.crmSystem.crm_backend.Collections.Customer;
import com.crmSystem.crm_backend.Collections.Employee;
import com.crmSystem.crm_backend.DTO.ServiceDto;
import com.crmSystem.crm_backend.Exception.ResourcerNotFoundException;
import com.crmSystem.crm_backend.Mapper.ServicesMapper;
import com.crmSystem.crm_backend.Repository.CustomerRepository;
import com.crmSystem.crm_backend.Repository.EmployeeRepository;
import com.crmSystem.crm_backend.Repository.ServiceRepository;
import com.crmSystem.crm_backend.Collections.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@org.springframework.stereotype.Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    //create a template to store those services with a customer
    @Transactional
    public ServiceDto createService(ServiceDto serviceDto) {
        // Fetch the customer and employee entities using the IDs from the DTO
        Customer customer = customerRepository.findById(serviceDto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Employee employee = employeeRepository.findById(serviceDto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Service service = ServicesMapper.mapToService(serviceDto, customer, employee);
       //does not need try catch, because we can add services as many as we want for the same customer and employee
        return ServicesMapper.mapToServiceDto(serviceRepository.save(service));
    }

    @Transactional
    public List<ServiceDto> findAllServices() {
        List<Service> services = serviceRepository.findAll();
        return ServicesMapper.mapToServicesDtoList(services);
    }

    //find all services by customer id
    @Transactional(readOnly = true)
    public List<ServiceDto> findServicesByCustomerId(Long customerId) {
        List<Service> serviceList = serviceRepository.findByCustomerId(customerId);
        return ServicesMapper.mapToServicesDtoList(serviceList);
    }
    //find all services by employee id
    @Transactional(readOnly = true)
    public List<ServiceDto> findServicesByEmployeeId(Long employeeId) {
        List<Service> serviceList = serviceRepository.findByEmployeeId(employeeId);
        return ServicesMapper.mapToServicesDtoList(serviceList);
    }

    public void addServiceImage(Long serviceId, byte[] image) {
        Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourcerNotFoundException("Service not found"));

        service.getServiceImg().add(image);
        serviceRepository.save(service);
    }

    public List<byte[]> getServiceImages(Long serviceId) {
        Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourcerNotFoundException("Service not found"));

        return service.getServiceImg();
    }
}
