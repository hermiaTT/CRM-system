package com.crmSystem.crm_backend.Service;

import com.crmSystem.crm_backend.DTO.ServicesDto;
import com.crmSystem.crm_backend.Collections.Customers;
import com.crmSystem.crm_backend.Mapper.ServicesMapper;
import com.crmSystem.crm_backend.Repository.ServiceRepository;
import com.crmSystem.crm_backend.Collections.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    //create a template to store those services with a customer
    @Autowired
    private MongoTemplate mongoTemplate;
    DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    //create service from one client and add the service to the current client data
    public ServicesDto createService(Map<String, Object> request) {

        String phoneNumber = request.get("phoneNumber").toString();

        Map<String,Object> requestBody = (Map<String, Object>) request.get("requestBody");

        ServicesDto servicesDTO = new ServicesDto();

        servicesDTO.setTotalPaid(Float.parseFloat(requestBody.get("totalPaid").toString()));
       //convert serviceDate to Date
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            servicesDTO.setServiceDate(simpleDateFormat.parse(requestBody.get("serviceDate").toString()));
        }catch(Exception e){
            throw new RuntimeException("Failed to parse date");
        }
//        List<ServiceInfo> services = ( List<ServiceInfo>)request.get("services");
        Services service = serviceRepository.insert(ServicesMapper.mapToServices(servicesDTO));

        //find the customer who I want to insert the service by phone, update the servicesIds in the customer
        mongoTemplate.update(Customers.class)
                .matching(Criteria.where("phoneNumber").is(phoneNumber))
                .apply(new Update().push("serviceIds").value(service))
                .first();

    return ServicesMapper.mapToServicesDto(service);

    }
}
