package com.crmSystem.crm_backend.Controller;


import com.crmSystem.crm_backend.DTO.ServiceDto;
import com.crmSystem.crm_backend.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity<ServiceDto> addNewService(@RequestBody ServiceDto serviceDto) {
        return new ResponseEntity<ServiceDto>(serviceService.createService(serviceDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ServiceDto>> getAllServices() {
     return new ResponseEntity<List<ServiceDto>>(serviceService.findAllServices(), HttpStatus.OK);
    }

    //find by customer id
    @GetMapping("/customer/{id}")
    public ResponseEntity<List<ServiceDto>> getServiceByCustomerId(@PathVariable Long id) {
        return new ResponseEntity<List<ServiceDto>>(serviceService.findServicesByCustomerId(id), HttpStatus.OK);
    }

    //find by employee id
    @GetMapping("/employee/{id}")
    public ResponseEntity<List<ServiceDto>> getServiceByEmployeeId(@PathVariable Long id) {
        return new ResponseEntity<List<ServiceDto>>(serviceService.findServicesByEmployeeId(id), HttpStatus.OK);
    }
}
