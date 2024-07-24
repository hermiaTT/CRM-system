package com.crmSystem.crm_backend.Mapper;

import com.crmSystem.crm_backend.Collections.Services;
import com.crmSystem.crm_backend.DTO.ServicesDto;

public class ServicesMapper {
    public static ServicesDto mapToServicesDto(Services services){
        return new ServicesDto(
                services.getId(),
                services.getTotalPaid(),
                services.getServiceDate()
        );
    }

    public static Services mapToServices(ServicesDto servicesDto){
        return new Services(
                servicesDto.getId(),
                servicesDto.getTotalPaid(),
                servicesDto.getServiceDate()
        );
    }
}
