package com.crmSystem.crm_backend.Controller;


import com.crmSystem.crm_backend.Service.ServiceService;
import com.crmSystem.crm_backend.DataCollection.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/services")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity<Services> createService(@RequestBody Map<String, Object> payload) {
        return new ResponseEntity<Services>(serviceService.createService(payload), HttpStatus.CREATED);
    }
}
