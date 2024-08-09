package com.crmSystem.crm_backend.Mapper;

import com.crmSystem.crm_backend.Collections.Customer;
import com.crmSystem.crm_backend.Collections.Employee;
import com.crmSystem.crm_backend.Collections.Service;
import com.crmSystem.crm_backend.DTO.ServiceDto;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class ServicesMapper {
    public static ServiceDto mapToServiceDto(Service service){
        return new ServiceDto(
                service.getId(),
                service.getServiceType(),
                service.getServicePrice(),
                service.getIsTaxed(),
                service.getTips(),
                service.getTotalPaid(),
                service.getServiceDate().getTime(),
                service.getServiceImg(),
                service.getCustomer().getFirstName() + " " + service.getCustomer().getLastName(),
                service.getEmployee().getFirstName() + " " + service.getEmployee().getLastName(),
                service.getCustomer().getId(),
                service.getEmployee().getId()
        );
    }

    public static Service mapToService(ServiceDto serviceDto, Customer customer, Employee employee){
        // The mapping from DTO to Entity would be more complex if handling relationships, assuming basic mapping here
        Service service = new Service();
        service.setId(serviceDto.getId());
        service.setServiceType(serviceDto.getServiceType());
        service.setServicePrice(serviceDto.getServicePrice());
        service.setIsTaxed(serviceDto.getIsTaxed());
        service.setTips(serviceDto.getTips());
        service.setTotalPaid(serviceDto.getTotalPaid());
        service.setServiceDate(new Timestamp(serviceDto.getServiceDate()));
        service.setServiceImg(serviceDto.getServiceImg());
        // Customer and Employee should be fetched from their respective repositories if needed
        service.setCustomer(customer);  // Set the customer entity
        service.setEmployee(employee);  // Set the employee entity

        return service;
    }

    public static List<ServiceDto> mapToServicesDtoList(List<Service> services){
        return services.stream()
                .map(ServicesMapper::mapToServiceDto)
                .collect(Collectors.toList());
    }
}
