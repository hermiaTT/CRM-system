package com.crmSystem.crm_backend.Service;

import com.crmSystem.crm_backend.DTO.ServiceDTO;
import com.crmSystem.crm_backend.DataCollection.Customers;
import com.crmSystem.crm_backend.Repository.ServiceRepository;
import com.crmSystem.crm_backend.DataCollection.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.*;

@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    //create a template to store those services with a customer
    @Autowired
    private MongoTemplate mongoTemplate;
    DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public Services createService(Map<String, Object> request) {
        String phoneNumber = request.get("phoneNumber").toString();
        Map<String,Object> requestBody = (Map<String, Object>) request.get("requestBody");
        ServiceDTO serviceDTO = new ServiceDTO();

        serviceDTO.setTotalPaid(Float.parseFloat(requestBody.get("totalPaid").toString()));
       //convert serviceDate to Date
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            serviceDTO.setServiceDate(simpleDateFormat.parse(requestBody.get("serviceDate").toString()));
        }catch(Exception e){
            throw new RuntimeException("Failed to parse date");
        }
//        List<ServiceInfo> services = ( List<ServiceInfo>)request.get("services");
        Services service = serviceRepository.insert(new Services(serviceDTO.getTotalPaid(), serviceDTO.getServiceDate()));

        //find the customer who I want to insert the service by phone, update the servicesIds in the customer
        mongoTemplate.update(Customers.class)
                .matching(Criteria.where("phoneNumber").is(phoneNumber))
                .apply(new Update().push("serviceIds").value(service))
                .first();
    return service;

    }
}
