package com.crmSystem.crm_backend.Mapper;

import com.crmSystem.crm_backend.Collections.Service;
import com.crmSystem.crm_backend.DTO.ServiceDto;

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
                service.getServiceDate(),
                service.getServiceImg(),
                service.getCustomerId(),
                service.getEmployeeId()
        );
    }

    public static Service mapToService(ServiceDto serviceDto){
        return new Service(
                serviceDto.getId(),
                serviceDto.getServiceType(),
                serviceDto.getServicePrice(),
                serviceDto.getIsTaxed(),
                serviceDto.getTips(),
                serviceDto.getTotalPaid(),
                serviceDto.getServiceDate(),
                serviceDto.getServiceImg(),
                serviceDto.getCustomerId(),
                serviceDto.getEmployeeId()
        );
    }

    public static List<ServiceDto> mapToServicesDtoList(List<Service> services){
        return services.stream()
                .map(ServicesMapper::mapToServiceDto)
                .collect(Collectors.toList());
    }
}
